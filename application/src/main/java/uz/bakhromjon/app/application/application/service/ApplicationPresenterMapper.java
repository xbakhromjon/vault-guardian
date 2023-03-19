package uz.bakhromjon.app.application.application.service;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.bakhromjon.app.application.application.port.in.CreateApplicationUseCase.ApplicationCreateRequest;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.application.domain.Application;

import java.util.Objects;

import static uz.bakhromjon.app.application.application.port.in.UpdateApplicationUseCase.ApplicationUpdateRequest;

@Mapper(componentModel = "spring")
public abstract class ApplicationPresenterMapper {
    public abstract Application mapToModelOnlyOwnFields(ApplicationCreateRequest createRequest);

    public Application mapToModel(ApplicationCreateRequest createRequest) {
        if (Objects.isNull(createRequest)) return null;
        Application application = mapToModelOnlyOwnFields(createRequest);
        // some logic
        return application;
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void mapToModelOnlyOwnFields(ApplicationUpdateRequest updateRequest,
                                                 @MappingTarget Application application);

    public Application mapToModel(ApplicationUpdateRequest updateRequest, Application application) {
        if (Objects.isNull(updateRequest)) return null;
        mapToModelOnlyOwnFields(updateRequest, application);
        // some logic
        return application;
    }


    public abstract ApplicationResponse mapToResponse(Application application);


}
