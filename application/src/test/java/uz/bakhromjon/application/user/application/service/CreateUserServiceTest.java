package uz.bakhromjon.application.user.application.service;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import uz.bakhromjon.application.user.application.port.in.CreateUserUseCase;
import uz.bakhromjon.application.user.application.port.out.SaveUserPort;
import uz.bakhromjon.application.user.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.eq;
import static org.mockito.BDDMockito.given;

class CreateUserServiceTest {
    private final SaveUserPort saveUserPort = Mockito.mock(SaveUserPort.class);
    private final UserPresenterMapper USER_PRESENTER_MAPPER = Mappers.getMapper(UserPresenterMapper.class);
    private final CreateUserService createUserService =
            new CreateUserService(saveUserPort);

    @Test
    void create() {
        CreateUserUseCase.UserCreateRequest createRequest =
                new CreateUserUseCase.UserCreateRequest("xbakhromjon", "123", "123");
        User user = USER_PRESENTER_MAPPER.mapToModel(createRequest);

        mockSaveUserMethod(user);

        User result = createUserService.create(createRequest);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getEmail()).isEqualTo(createRequest.getEmail());
        assertThat(result.getMasterPassword()).isEqualTo(createRequest.getMasterPassword());
        assertThat(result.getHint()).isEqualTo(createRequest.getHint());
    }

    void mockSaveUserMethod(User user) {
        given(saveUserPort.save(eq(user)))
                .willAnswer(invocationOnMock -> {
                            user.setId(1L);
                            return user;
                        }
                );
    }
}



