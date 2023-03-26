package uz.bakhromjon.application.application.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.application.application.port.in.CreateApplicationUseCase;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.application.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.common.UseCase;

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
