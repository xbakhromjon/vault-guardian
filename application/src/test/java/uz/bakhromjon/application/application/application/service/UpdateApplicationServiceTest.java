package uz.bakhromjon.application.application.application.service;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.mockito.BDDMockito.*;

import org.mockito.Mockito;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.application.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.application.application.application.port.in.UpdateApplicationUseCase;

import static org.assertj.core.api.Assertions.*;

class UpdateApplicationServiceTest {
    private final ApplicationPresenterMapper applicationPresenterMapper =
            Mappers.getMapper(ApplicationPresenterMapper.class);
    private final LoadApplicationPort loadApplicationPort = Mockito.mock(LoadApplicationPort.class);

    private final UpdateApplicationService updateApplicationService =
            new UpdateApplicationService(applicationPresenterMapper, loadApplicationPort);


    @Test
    void executeSucceeds() {
        UpdateApplicationUseCase.ApplicationUpdateRequest updateRequest = new UpdateApplicationUseCase.ApplicationUpdateRequest(1L, "M");
        givenApplicationIdExists(updateRequest.getId());
        ApplicationResponse result = updateApplicationService.execute(updateRequest);
        assertThat(result.getMessage()).isEqualTo("M");
    }

    private void givenApplicationIdExists(Long applicationId) {
        given(loadApplicationPort.loadById(eq(applicationId))).willReturn(Application.builder().id(applicationId).build());
    }


}