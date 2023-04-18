package uz.bakhromjon.application.password.application.service;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.UpdatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class PasswordPresenterMapper {
    public abstract Password mapToModel(CreatePasswordUseCase.PasswordCreateRequest source);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Password mapToModel(UpdatePasswordUseCase.PasswordUpdateRequest source, @MappingTarget Password target);


    public abstract PasswordResponse mapToResponse(Password source);


    public List<PasswordResponse> mapToResponse(List<Password> source) {
        if (Objects.isNull(source)) return null;
        return source.stream().map(this::mapToResponse).toList();
    }
}

