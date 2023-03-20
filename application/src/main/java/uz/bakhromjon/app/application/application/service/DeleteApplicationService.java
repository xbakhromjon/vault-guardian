package uz.bakhromjon.app.application.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.app.application.application.port.in.DeleteApplicationUseCase;
import uz.bakhromjon.app.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.app.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.app.application.domain.Application;
import uz.bakhromjon.app.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class DeleteApplicationService implements DeleteApplicationUseCase {
    private final LoadApplicationPort loadApplicationPort;
    private final SaveApplicationPort saveApplicationPort;

    @Override
    public boolean execute(Long applicationId) {
        Application application = loadApplicationPort.loadById(applicationId);
        application.setIsDeleted(Boolean.TRUE);

        application = saveApplicationPort.save(application);
        return application.getIsDeleted();
    }
}
