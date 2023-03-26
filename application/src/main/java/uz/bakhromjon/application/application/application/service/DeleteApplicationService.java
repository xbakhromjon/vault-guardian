package uz.bakhromjon.application.application.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.application.application.port.in.DeleteApplicationUseCase;
import uz.bakhromjon.application.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.application.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.common.UseCase;

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
