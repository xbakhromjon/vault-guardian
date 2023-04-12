package uz.bakhromjon.application.passport.application.port.in;

import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.passport.application.port.in.criteria.PassportSearchCriteria;
import uz.bakhromjon.application.passport.application.port.in.response.PassportResponse;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;

public interface GetPassportQuery {
    PassportResponse getById(Passport.PassportId id);
    PageableResponse<PassportResponse> search(PassportSearchCriteria criteria);
}
