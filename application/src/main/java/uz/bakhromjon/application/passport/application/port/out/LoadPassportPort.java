package uz.bakhromjon.application.passport.application.port.out;

import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.passport.application.port.in.PassportSearchCriteria;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.application.user.domain.User;

public interface LoadPassportPort {
    Passport load(Passport.PassportId passportId, User.UserId requestedUserId);
    Passport loadForUpdate(Passport.PassportId passportId, User.UserId requestedUserId);

    PageableResponse<Passport> search(PassportSearchCriteria criteria);
}
