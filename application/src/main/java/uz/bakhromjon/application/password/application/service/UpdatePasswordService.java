package uz.bakhromjon.application.password.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.application.password.application.port.in.UpdatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.PasswordResponse;
import uz.bakhromjon.application.password.application.port.out.LoadPasswordPort;
import uz.bakhromjon.application.password.application.port.out.SavePasswordPort;
import uz.bakhromjon.application.password.domain.Password;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class UpdatePasswordService implements UpdatePasswordUseCase {
    private final PasswordPresenterMapper passwordPresenterMapper;
    private final LoadPasswordPort loadPasswordPort;
    private final SessionUserService sessionUserService;
    private final SavePasswordPort savePasswordPort;

    @Override
    public PasswordResponse update(PasswordUpdateRequest updateRequest) {
        Password password = loadPasswordPort.loadForUpdate(updateRequest.getId(), sessionUserService.getSessionId());
        passwordPresenterMapper.mapToModel(updateRequest, password);
        password = savePasswordPort.save(password);
        return passwordPresenterMapper.mapToResponse(password);
    }
}
