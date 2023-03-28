package uz.bakhromjon.application.token.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.application.token.domain.AccessToken;

@Mapper(componentModel = "spring")
public interface AccessTokenPresenterMapper {
    AccessTokenPresenterMapper INSTANCE = Mappers.getMapper(AccessTokenPresenterMapper.class);

    AccessTokenResponse mapToResponse(AccessToken source);
}
