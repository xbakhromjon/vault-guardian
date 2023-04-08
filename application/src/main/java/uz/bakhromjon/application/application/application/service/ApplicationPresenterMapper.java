package uz.bakhromjon.application.application.application.service;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.bakhromjon.application.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.application.application.application.port.in.UpdateApplicationUseCase;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.application.application.domain.Application;

import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class ApplicationPresenterMapper {
    public abstract Application mapToModelOnlyOwnFields(CreateApplicationUseCase.ApplicationCreateRequest createRequest);

    public Application mapToModel(CreateApplicationUseCase.ApplicationCreateRequest createRequest) {
        if (Objects.isNull(createRequest)) return null;
        Application application = mapToModelOnlyOwnFields(createRequest);
        // some logic
        return application;
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void mapToModelOnlyOwnFields(UpdateApplicationUseCase.ApplicationUpdateRequest updateRequest,
                                                 @MappingTarget Application application);

    public Application mapToModel(UpdateApplicationUseCase.ApplicationUpdateRequest updateRequest, Application application) {
        if (Objects.isNull(updateRequest)) return null;
        mapToModelOnlyOwnFields(updateRequest, application);
        // some logic
        return application;
    }


    public abstract ApplicationResponse mapToResponse(Application application);


}
