package uz.bakhromjon.application.passport.application.port.in;

import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.passport.domain.Passport;

public interface GetPassportQuery {
    PassportResponse getById(Passport.PassportId id);
    PageableResponse<PassportResponse> search(PassportSearchCriteria criteria);
}
