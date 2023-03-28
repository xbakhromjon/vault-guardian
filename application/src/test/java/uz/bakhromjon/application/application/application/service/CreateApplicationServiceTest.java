package uz.bakhromjon.application.application.application.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.mockito.BDDMockito.*;

import org.mockito.Mockito;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.application.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.application.application.application.port.in.CreateApplicationUseCase;

class CreateApplicationServiceTest {

    private final SaveApplicationPort saveApplicationPort =
            Mockito.mock(SaveApplicationPort.class);
    private final ApplicationPresenterMapper applicationPresenterMapper = Mappers.getMapper(ApplicationPresenterMapper.class);
    private final CreateApplicationService createApplicationService =
            new CreateApplicationService(applicationPresenterMapper,
                    saveApplicationPort);


    @Test
    void executeSucceeds() {
        CreateApplicationUseCase.ApplicationCreateRequest createRequest = new CreateApplicationUseCase.ApplicationCreateRequest(1L, "M");
        givenCreateRequestSaveSuccess(createRequest);
        ApplicationResponse result = createApplicationService.execute(createRequest);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getApplicantId()).isEqualTo(1L);
        assertThat(result.getMessage()).isEqualTo("M");
    }

    private void givenCreateRequestSaveSuccess(CreateApplicationUseCase.ApplicationCreateRequest createRequest) {
        Application application = applicationPresenterMapper.mapToModel(createRequest);
        given(saveApplicationPort.save(any(Application.class))).willAnswer(invocationOnMock -> {
            application.setId(1L);
            return application;
        });
    }

}


