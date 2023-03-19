package uz.bakhromjon.app.application.application.service;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.mockito.BDDMockito.*;

import org.mockito.Mockito;
import uz.bakhromjon.app.application.application.port.in.UpdateApplicationUseCase.*;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.app.application.domain.Application;

import static org.assertj.core.api.Assertions.*;

class UpdateApplicationServiceTest {
    private final ApplicationPresenterMapper applicationPresenterMapper =
            Mappers.getMapper(ApplicationPresenterMapper.class);
    private final LoadApplicationPort loadApplicationPort = Mockito.mock(LoadApplicationPort.class);

    private final UpdateApplicationService updateApplicationService =
            new UpdateApplicationService(applicationPresenterMapper, loadApplicationPort);


    @Test
    void executeSucceeds() {
        ApplicationUpdateRequest updateRequest = new ApplicationUpdateRequest(1L, "M");
        givenApplicationIdExists(updateRequest.getId());
        ApplicationResponse result = updateApplicationService.execute(updateRequest);
        assertThat(result.getMessage()).isEqualTo("M");
    }

    private void givenApplicationIdExists(Long applicationId) {
        given(loadApplicationPort.loadById(eq(applicationId))).willReturn(Application.builder().id(applicationId).build());
    }


}