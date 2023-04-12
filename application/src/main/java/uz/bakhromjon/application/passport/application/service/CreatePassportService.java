package uz.bakhromjon.application.passport.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.application.passport.application.port.in.CreatePassportUseCase;
import uz.bakhromjon.application.passport.application.port.in.response.PassportResponse;
import uz.bakhromjon.application.passport.application.port.out.SavePassportPort;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class CreatePassportService implements CreatePassportUseCase {
    private final PassportPresenterMapper passportPresenterMapper;
    private final SavePassportPort savePassportPort;
    private final SessionUserService sessionUserService;

    @Override
    public PassportResponse create(PassportCreateRequest createRequest) {
        Passport passport = passportPresenterMapper.mapToModel(createRequest);
        passport.setOwnerId(sessionUserService.getSessionId());
        passport = savePassportPort.save(passport);
        return passportPresenterMapper.mapToResponse(passport);
    }
}


