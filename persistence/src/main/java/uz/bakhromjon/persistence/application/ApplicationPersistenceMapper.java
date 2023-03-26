package uz.bakhromjon.persistence.application;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.application.domain.Application;

import java.util.Objects;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ApplicationPersistenceMapper {
    ApplicationPersistenceMapper INSTANCE = Mappers.getMapper(ApplicationPersistenceMapper.class);


    Application mapToModelWithOutInnerEntity(ApplicationJpaEntity source);

    default Application mapToModel(ApplicationJpaEntity source) {
        if (Objects.isNull(source)) return null;
        Application destination = mapToModelWithOutInnerEntity(source);
        // some logic
        return destination;
    }

    ApplicationJpaEntity mapToEntity(Application source);
}
