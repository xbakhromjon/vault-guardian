package uz.bakhromjon.application.passport.application.service;

import org.mapstruct.*;
import uz.bakhromjon.application.passport.application.port.in.CreatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.UpdatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.PassportResponse;
import uz.bakhromjon.application.passport.domain.Passport;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class PassportPresenterMapper {
    public abstract Passport mapToModel(CreatePassportUseCase.PassportCreateRequest createRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Passport mapToModel(UpdatePassportUseCase.PassportUpdateRequest updateRequest, @MappingTarget Passport passport);


    public abstract PassportResponse mapToResponse(Passport passport);

    public List<PassportResponse> mapToResponse(Collection<Passport> source) {
        if (Objects.isNull(source)) return null;
        return source.stream().map(this::mapToResponse).toList();
    }
}

