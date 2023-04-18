package uz.bakhromjon.application.password.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.application.password.application.port.in.GetPasswordQuery;
import uz.bakhromjon.application.password.application.port.in.PasswordSearchCriteria;
import uz.bakhromjon.application.password.application.port.in.PasswordResponse;
import uz.bakhromjon.application.password.application.port.out.LoadPasswordPort;
import uz.bakhromjon.application.password.domain.Password;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class GetPasswordService implements GetPasswordQuery {
    private final LoadPasswordPort loadPasswordPort;
    private final PasswordPresenterMapper passwordPresenterMapper;
    private final SessionUserService sessionUserService;

    @Override
    public PasswordResponse getById(Password.PasswordId id) {
        Password password = loadPasswordPort.load(id, sessionUserService.getSessionId());
        return passwordPresenterMapper.mapToResponse(password);
    }

    @Override
    public PageableResponse<PasswordResponse> search(PasswordSearchCriteria criteria) {
        PageableResponse<Password> result = loadPasswordPort.search(criteria);
        return PageableResponse.build(result, passwordPresenterMapper.mapToResponse(result.getContent()));
    }
}
