package uz.bakhromjon.application.password.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.application.port.out.SavePasswordPort;
import uz.bakhromjon.application.password.domain.Password;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class CreatePasswordService implements CreatePasswordUseCase {
    private final PasswordPresenterMapper passwordPresenterMapper;
    private final SavePasswordPort savePasswordPort;
    private final SessionUserService sessionUserService;

    @Override
    public PasswordResponse create(PasswordCreateRequest createRequest) {
        Password password = passwordPresenterMapper.mapToModel(createRequest);
        password.setOwnerId(sessionUserService.getSessionId());
        password = savePasswordPort.save(password);
        return passwordPresenterMapper.mapToResponse(password);
    }
}


