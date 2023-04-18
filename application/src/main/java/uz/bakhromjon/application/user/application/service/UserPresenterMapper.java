package uz.bakhromjon.application.user.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.user.application.port.in.CreateUserUseCase;
import uz.bakhromjon.application.user.application.port.in.UserResponse;
import uz.bakhromjon.application.user.domain.User;

@Mapper(componentModel = "spring")
public interface UserPresenterMapper {
    UserPresenterMapper INSTANCE = Mappers.getMapper(UserPresenterMapper.class);
    User mapToModel(CreateUserUseCase.UserCreateRequest createRequest);

    UserResponse mapToResponse(User source);
}
