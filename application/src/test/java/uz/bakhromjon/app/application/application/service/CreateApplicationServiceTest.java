package uz.bakhromjon.app.application.application.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.mockito.BDDMockito.*;

import org.mockito.Mockito;
import uz.bakhromjon.app.application.application.port.in.CreateApplicationUseCase.ApplicationCreateRequest;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.app.application.domain.Application;

class CreateApplicationServiceTest {
    private final SaveApplicationPort saveApplicationPort =
            Mockito.mock(SaveApplicationPort.class);
    private final ApplicationPresenterMapper applicationPresenterMapper = Mappers.getMapper(ApplicationPresenterMapper.class);
    private final CreateApplicationService createApplicationService =
            new CreateApplicationService(applicationPresenterMapper,
                    saveApplicationPort);


    @Test
    void executeSucceeds() {
        ApplicationCreateRequest createRequest = new ApplicationCreateRequest(1L, "M");
        givenCreateRequestSaveSuccess(createRequest);
        ApplicationResponse result = createApplicationService.execute(createRequest);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getApplicantId()).isEqualTo(1L);
        assertThat(result.getMessage()).isEqualTo("M");
    }

    private void givenCreateRequestSaveSuccess(ApplicationCreateRequest createRequest) {
        Application application = applicationPresenterMapper.mapToModel(createRequest);
        given(saveApplicationPort.save(any(Application.class))).willAnswer(invocationOnMock -> {
            application.setId(1L);
            return application;
        });
    }

}


