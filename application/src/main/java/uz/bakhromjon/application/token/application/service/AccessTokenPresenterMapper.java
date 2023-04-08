package uz.bakhromjon.application.token.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.application.token.domain.AccessToken;

@Mapper(componentModel = "spring")
public interface AccessTokenPresenterMapper {
    AccessTokenPresenterMapper INSTANCE = Mappers.getMapper(AccessTokenPresenterMapper.class);

    AccessTokenResponse mapToResponse(AccessToken source);
}
