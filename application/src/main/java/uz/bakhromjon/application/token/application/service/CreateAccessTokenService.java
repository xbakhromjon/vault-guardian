package uz.bakhromjon.application.token.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.token.application.port.in.CreateAccessTokenUseCase;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.application.token.application.port.out.SaveAccessTokenPort;
import uz.bakhromjon.application.token.domain.AccessToken;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class CreateAccessTokenService implements CreateAccessTokenUseCase {
    private final SaveAccessTokenPort saveAccessTokenPort;
    private final AccessTokenPresenterMapper ACCESS_TOKEN_PRESENTER_MAPPER = AccessTokenPresenterMapper.INSTANCE;

    @Override
    public AccessTokenResponse create(User user) {
        AccessToken accessToken = AccessToken.create(user);
        accessToken = saveAccessTokenPort.save(accessToken);
        return ACCESS_TOKEN_PRESENTER_MAPPER.mapToResponse(accessToken);
    }


}
