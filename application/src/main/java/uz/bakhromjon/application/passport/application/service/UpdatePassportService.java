package uz.bakhromjon.application.passport.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.application.passport.application.port.in.UpdatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.response.PassportResponse;
import uz.bakhromjon.application.passport.application.port.out.LoadPassportPort;
import uz.bakhromjon.application.passport.application.port.out.SavePassportPort;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class UpdatePassportService implements UpdatePassportUseCase {
    private final PassportPresenterMapper passportPresenterMapper;
    private final LoadPassportPort loadPassportPort;
    private final SessionUserService sessionUserService;
    private final SavePassportPort savePassportPort;

    @Override
    public PassportResponse update(PassportUpdateRequest updateRequest) {
        Passport passport = loadPassportPort.loadForUpdate(updateRequest.getId(), sessionUserService.getSessionId());
        passportPresenterMapper.mapToModel(updateRequest, passport);
        passport = savePassportPort.save(passport);
        return passportPresenterMapper.mapToResponse(passport);
    }
}
