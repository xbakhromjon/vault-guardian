package uz.bakhromjon.app.application.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.app.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.app.application.domain.Application;
import uz.bakhromjon.app.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class CreateApplicationService implements CreateApplicationUseCase {
    private final ApplicationPresenterMapper applicationPresenterMapper;
    private final SaveApplicationPort saveApplicationPort;

    @Override
    public ApplicationResponse execute(ApplicationCreateRequest createRequest) {
        Application application = applicationPresenterMapper.mapToModel(createRequest);
        application = saveApplicationPort.save(application);
        return applicationPresenterMapper.mapToResponse(application);
    }

}
