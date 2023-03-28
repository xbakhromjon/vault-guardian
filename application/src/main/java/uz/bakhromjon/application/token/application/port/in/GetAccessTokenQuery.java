package uz.bakhromjon.application.token.application.port.in;

import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;

public interface GetAccessTokenQuery {
    AccessTokenResponse getByToken(String token);
}
