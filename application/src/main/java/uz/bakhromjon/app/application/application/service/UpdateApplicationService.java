package uz.bakhromjon.app.application.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.app.application.application.port.in.UpdateApplicationUseCase;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.app.application.domain.Application;
import uz.bakhromjon.app.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class UpdateApplicationService implements UpdateApplicationUseCase {
    private final ApplicationPresenterMapper applicationPresenterMapper;
    private final LoadApplicationPort loadApplicationPort;

    @Override
    public ApplicationResponse execute(ApplicationUpdateRequest updateRequest) {
        Application application = loadApplicationPort.loadById(updateRequest.getId());
        applicationPresenterMapper.mapToModel(updateRequest, application);
        return applicationPresenterMapper.mapToResponse(application);
    }
}
