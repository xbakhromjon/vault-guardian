package uz.bakhromjon.persistence.common;

import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import uz.bakhromjon.application.common.BaseModel;

@MapperConfig
public interface AuditorMapperConfig {
    @Mapping(target = "auditor.createdAt", source = "createdAt")
    @Mapping(target = "auditor.updatedAt", source = "updatedAt")
    @Mapping(target = "auditor.deleted", source = "deleted")
    BaseEntity mapToEntity(BaseModel source);

    @Mapping(target = "createdAt", source = "auditor.createdAt")
    @Mapping(target = "updatedAt", source = "auditor.updatedAt")
    @Mapping(target = "deleted", source = "auditor.deleted")
    BaseModel mapToModel(BaseEntity source);
}
