package uz.bakhromjon.application.token.application.port.out;

import uz.bakhromjon.application.token.domain.AccessToken;

public interface SaveAccessTokenPort {
    AccessToken save(AccessToken accessToken);
}
