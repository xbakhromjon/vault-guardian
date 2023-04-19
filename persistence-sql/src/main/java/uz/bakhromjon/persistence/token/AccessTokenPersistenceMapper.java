package uz.bakhromjon.persistence.token;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.token.domain.AccessToken;
import uz.bakhromjon.persistence.user.UserPersistenceMapper;

@Mapper(uses = UserPersistenceMapper.class)
public interface AccessTokenPersistenceMapper {
    AccessTokenPersistenceMapper INSTANCE = Mappers.getMapper(AccessTokenPersistenceMapper.class);

    AccessToken mapToModel(AccessTokenJpaEntity source);

    AccessTokenJpaEntity mapToEntity(AccessToken source);
}
