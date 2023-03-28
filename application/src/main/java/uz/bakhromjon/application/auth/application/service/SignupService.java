package uz.bakhromjon.application.auth.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.auth.application.port.in.SignUpUseCase;
import uz.bakhromjon.application.common.ApplicationErrorDataKey;
import uz.bakhromjon.application.common.ApplicationErrorMessage;
import uz.bakhromjon.application.token.application.port.in.CreateAccessTokenUseCase;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.application.user.application.port.out.LoadUserPort;
import uz.bakhromjon.application.user.application.port.out.SaveUserPort;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.ErrorData;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class SignupService implements SignUpUseCase {
    // TODO: 3/3/2023 BAKHROMJON (P2): email verification qo'shish kerak
    private final AuthMapper authMapper;
    private final SaveUserPort saveUserPort;
    private final CreateAccessTokenUseCase createAccessTokenUseCase;
    private final LoadUserPort loadUserPort;

    @Override
    public AccessTokenResponse signup(SignupRequest signUpRequest) throws EmailAlreadyTakenException {
        if (loadUserPort.existsByEmail(signUpRequest.getEmail())) {
            throw new EmailAlreadyTakenException(ApplicationErrorMessage.EMAIL_ALREADY_TAKEN, new ErrorData(ApplicationErrorDataKey.EMAIL, signUpRequest.getEmail()));
        }
        User user = authMapper.mapToModel(signUpRequest);
        user = saveUserPort.save(user);
        return createAccessTokenUseCase.create(user);
    }
}

