package uz.bakhromjon.persistence.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.user.domain.User;

@Mapper
public interface UserPersistenceMapper {
    UserPersistenceMapper INSTANCE = Mappers.getMapper(UserPersistenceMapper.class);

    User mapToModel(UserJpaEntity source);

    UserJpaEntity mapToEntity(User source);
}
