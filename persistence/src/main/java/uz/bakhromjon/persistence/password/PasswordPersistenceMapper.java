package uz.bakhromjon.persistence.password;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.password.domain.Password;

@Mapper
public interface PasswordPersistenceMapper {
    PasswordPersistenceMapper INSTANCE = Mappers.getMapper(PasswordPersistenceMapper.class);

    PasswordJpaEntity mapToEntity(Password source);

    Password mapToModel(PasswordJpaEntity source);
}
