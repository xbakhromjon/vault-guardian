package uz.bakhromjon.application.auth.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.auth.application.port.in.SignInUseCase;
import uz.bakhromjon.application.common.AES;
import uz.bakhromjon.application.common.ApplicationErrorMessage;
import uz.bakhromjon.application.token.application.port.in.CreateAccessTokenUseCase;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.application.user.application.port.out.LoadUserPort;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class SignInService implements SignInUseCase {
    private final LoadUserPort loadUserPort;
    private final CreateAccessTokenUseCase createAccessTokenUseCase;

    @Override
    public AccessTokenResponse signIn(SignInRequest signInRequest) throws BadCredentialsException {
        User user = loadUserPort.loadByEmail(signInRequest.getEmail());
        String masterPassword;
        try {
            masterPassword = AES.decrypt(user.getMasterPassword(), AES.getKey());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!masterPassword.equals(signInRequest.getMasterPassword())) {
            throw new BadCredentialsException(ApplicationErrorMessage.BAD_CREDENTIALS);
        }
        return createAccessTokenUseCase.create(user);
    }
}
