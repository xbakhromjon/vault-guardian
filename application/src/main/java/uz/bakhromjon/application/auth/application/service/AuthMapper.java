package uz.bakhromjon.application.auth.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.bakhromjon.application.auth.application.port.in.SignUpUseCase;
import uz.bakhromjon.application.user.domain.User;

@Mapper(componentModel = "spring")
public abstract class AuthMapper {
    @Mapping(target = "masterPassword", ignore = true)
    public abstract User mapToModel(SignUpUseCase.SignupRequest signUpRequest);
}
