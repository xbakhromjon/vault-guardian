package uz.bakhromjon.application.token.application.port.in;

import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.application.user.domain.User;

public interface CreateAccessTokenUseCase {
    AccessTokenResponse create(User user);
}
