package uz.bakhromjon.persistence.password;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.password.domain.Password;

import java.util.List;

@Mapper
public interface PasswordPersistenceMapper {
    PasswordPersistenceMapper INSTANCE = Mappers.getMapper(PasswordPersistenceMapper.class);

    @Mapping(target = "id", source = "id.value")
    @Mapping(target = "owner.id", source = "ownerId.value")
    PasswordDocument mapToEntity(Password source);

    @Mapping(target = "id.value", source = "id")
    @Mapping(target = "ownerId.value", source = "owner.id")
    Password mapToModel(PasswordDocument source);


    List<Password> mapToModel(List<PasswordDocument> source);
}
