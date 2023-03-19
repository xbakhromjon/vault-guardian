package uz.bakhromjon.app.application.application.service;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.mockito.Mockito;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.app.application.domain.Application;

class GetApplicationServiceTest {
    private final LoadApplicationPort loadApplicationPort =
            Mockito.mock(LoadApplicationPort.class);

    private final ApplicationPresenterMapper applicationPresenterMapper
            = Mappers.getMapper(ApplicationPresenterMapper.class);

    private final GetApplicationService getApplicationService =
            new GetApplicationService(loadApplicationPort, applicationPresenterMapper);


    @Test
    void executeSuccess() {
        Long id = 1L;
        givenIdSuccessLoadApplication(id);
        ApplicationResponse result = getApplicationService.execute(id);
        assertThat(result.getApplicantId()).isEqualTo(id);
        assertThat(result.getApplicantId()).isEqualTo(1L);
        assertThat(result.getMessage()).isEqualTo("M");
    }

    private void givenIdSuccessLoadApplication(Long id) {
        Application application = Application.builder().
                id(id).applicantId(1L).message("M").build();
        given(loadApplicationPort.loadById(id)).willReturn(application);
    }


}