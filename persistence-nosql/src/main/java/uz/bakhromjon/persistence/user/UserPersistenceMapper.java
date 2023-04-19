package uz.bakhromjon.persistence.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.user.domain.User;

@Mapper
public interface UserPersistenceMapper {
    UserPersistenceMapper INSTANCE = Mappers.getMapper(UserPersistenceMapper.class);

    @Mapping(target = "id.value", source = "id")
    User mapToModel(UserDocument source);

    @Mapping(target = "id", source = "id.value")
    UserDocument mapToEntity(User source);
}
