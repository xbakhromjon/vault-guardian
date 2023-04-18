package uz.bakhromjon.application.passport.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.application.passport.application.port.in.GetPassportQuery;
import uz.bakhromjon.application.passport.application.port.in.PassportSearchCriteria;
import uz.bakhromjon.application.passport.application.port.in.PassportResponse;
import uz.bakhromjon.application.passport.application.port.out.LoadPassportPort;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class GetPassportService implements GetPassportQuery {
    private final LoadPassportPort loadPassportPort;
    private final PassportPresenterMapper passportPresenterMapper;
    private final SessionUserService sessionUserService;

    @Override
    public PassportResponse getById(Passport.PassportId id) {
        Passport passport = loadPassportPort.load(id, sessionUserService.getSessionId());
        return passportPresenterMapper.mapToResponse(passport);
    }

    @Override
    public PageableResponse<PassportResponse> search(PassportSearchCriteria criteria) {
        PageableResponse<Passport> result = loadPassportPort.search(criteria);
        return PageableResponse.build(result, passportPresenterMapper.mapToResponse(result.getContent()));
    }
}
