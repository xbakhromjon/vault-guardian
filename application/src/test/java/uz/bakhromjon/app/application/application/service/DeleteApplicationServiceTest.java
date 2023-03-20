package uz.bakhromjon.app.application.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uz.bakhromjon.app.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.app.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.app.application.domain.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

class DeleteApplicationServiceTest {
    private final LoadApplicationPort loadApplicationPort = Mockito.mock(LoadApplicationPort.class);

    private final SaveApplicationPort saveApplicationPort =
            Mockito.mock(SaveApplicationPort.class);

    private final DeleteApplicationService deleteApplicationService =
            new DeleteApplicationService(loadApplicationPort, saveApplicationPort);

    @Test
    void executeSucceeds() {
        Long id = 1L;
        Application application = givenApplicationIdExists(id);
        givenApplicationWillSuccessfullySave(application);

        boolean result = deleteApplicationService.execute(id);
        assertThat(result).isTrue();
    }

    @Test
    void executeWillFail() {
        Long id = null;
        Application application = givenApplicationIdExists(id);
        givenApplicationWillSuccessfullySave(application);

        boolean result = deleteApplicationService.execute(id);
        assertThat(result).isTrue();
    }

    private void givenApplicationWillSuccessfullySave(Application application) {
        given(saveApplicationPort.save(eq(application))).willReturn(application);
    }

    private Application givenApplicationIdExists(Long id) {
        Application application = Application.builder()
                .id(id)
                .applicantId(1L)
                .message("M")
                .isDeleted(Boolean.FALSE)
                .build();
        given(loadApplicationPort.loadById(eq(id))).willReturn(application);
        return application;
    }
}