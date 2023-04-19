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


    @Mapping(target = "id", source = "id.value")
    @Mapping(target = "owner.id", source = "ownerId.value")
    PassportDocument mapToEntity(Passport source);


    @Mapping(target = "id.value", source = "id")
    @Mapping(target = "ownerId.value", source = "owner.id")
    Passport mapToModel(PassportDocument source);

    List<Passport> mapToModel(Collection<PassportDocument> source);
}
