package uz.bakhromjon.persistence.passport;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.passport.domain.Passport;

import java.util.Collection;
import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PassportPersistenceMapper {
    PassportPersistenceMapper INSTANCE = Mappers.getMapper(PassportPersistenceMapper.class);

    @Mapping(target = "auditor.createdAt", source = "createdAt")
    @Mapping(target = "auditor.updatedAt", source = "updatedAt")
    @Mapping(target = "auditor.deleted", source = "deleted")
    @Mapping(target = "id", source = "id.value")
    @Mapping(target = "owner.id", source = "ownerId.value")
    PassportJpaEntity mapToEntity(Passport source);

    @Mapping(target = "createdAt", source = "auditor.createdAt")
    @Mapping(target = "updatedAt", source = "auditor.updatedAt")
    @Mapping(target = "deleted", source = "auditor.deleted")
    @Mapping(target = "id.value", source = "id")
    Passport mapToModel(PassportJpaEntity source);

    List<Passport> mapToModel(Collection<PassportJpaEntity> source);
}
