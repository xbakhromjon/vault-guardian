package uz.bakhromjon.persistence.token;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.token.application.port.out.DeleteAccessTokenOutPort;
import uz.bakhromjon.application.token.application.port.out.LoadAccessTokenPort;
import uz.bakhromjon.application.token.application.port.out.SaveAccessTokenPort;
import uz.bakhromjon.application.token.domain.AccessToken;
import uz.bakhromjon.common.ErrorData;
import uz.bakhromjon.common.PersistenceAdapter;
import uz.bakhromjon.persistence.common.DataNotFoundException;
import uz.bakhromjon.persistence.common.PersistenceErrorDataKey;
import uz.bakhromjon.persistence.common.PersistenceErrorMessage;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class AccessTokenPersistenceAdapter implements SaveAccessTokenPort, LoadAccessTokenPort, DeleteAccessTokenOutPort {
    private final AccessTokenRepository accessTokenRepository;
    private final AccessTokenPersistenceMapper ACCESS_TOKEN_PERSISTENCE_MAPPER = AccessTokenPersistenceMapper.INSTANCE;

    @Override
    public AccessToken loadByToken(String token) {
        Optional<AccessTokenDocument> optional = accessTokenRepository.findById(token);
        AccessTokenDocument entity = optional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.ACCESS_TOKEN_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.ACCESS_TOKEN, token));
        });
        return ACCESS_TOKEN_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public AccessToken save(AccessToken accessToken) {
        AccessTokenDocument entity = ACCESS_TOKEN_PERSISTENCE_MAPPER.mapToEntity(accessToken);
        entity = accessTokenRepository.save(entity);
        return ACCESS_TOKEN_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public void delete(String token) {
        accessTokenRepository.deleteByToken(token);
    }
}
