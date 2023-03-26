package uz.bakhromjon.application.application.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.application.application.port.in.GetApplicationQuery;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.application.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.common.UseCase;

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
