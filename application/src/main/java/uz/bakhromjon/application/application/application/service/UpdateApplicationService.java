package uz.bakhromjon.application.application.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.application.application.port.in.UpdateApplicationUseCase;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.application.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.common.UseCase;

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
