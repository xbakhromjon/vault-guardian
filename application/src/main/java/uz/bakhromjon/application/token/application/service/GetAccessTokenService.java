package uz.bakhromjon.application.token.application.service;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.token.application.port.in.GetAccessTokenQuery;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.application.token.application.port.out.LoadAccessTokenPort;
import uz.bakhromjon.application.token.domain.AccessToken;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class GetAccessTokenService implements GetAccessTokenQuery {
    private final LoadAccessTokenPort loadAccessTokenPort;
    private final AccessTokenPresenterMapper ACCESS_TOKEN_PRESENTER_MAPPER = Mappers.getMapper(AccessTokenPresenterMapper.class);
    @Override
    public AccessTokenResponse getByToken(String token) {
        AccessToken accessToken = loadAccessTokenPort.loadByToken(token);
        return ACCESS_TOKEN_PRESENTER_MAPPER.mapToResponse(accessToken);
    }
}
