package uz.bakhromjon.app.application.application.service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import uz.bakhromjon.app.application.application.port.in.GetApplicationQuery;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.app.application.domain.Application;
import uz.bakhromjon.app.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class GetApplicationService implements GetApplicationQuery {
    private final LoadApplicationPort loadApplicationPort;
    private final ApplicationPresenterMapper applicationPresenterMapper;

    @Override
    public ApplicationResponse execute(Long applicationId) {
        Application application = loadApplicationPort.loadById(applicationId);
        return applicationPresenterMapper.mapToResponse(application);
    }

}
