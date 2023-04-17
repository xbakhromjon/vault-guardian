package uz.bakhromjon.application.passport.application.port.out;

import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.passport.application.port.in.criteria.PassportSearchCriteria;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.application.password.application.port.in.criteria.PasswordSearchCriteria;
import uz.bakhromjon.application.password.domain.Password;
import uz.bakhromjon.application.user.domain.User;

public interface LoadPassportPort {
    Passport load(Passport.PassportId passportId, User.UserId requestedUserId);
    Passport loadForUpdate(Passport.PassportId passportId, User.UserId requestedUserId);

    PageableResponse<Passport> search(PassportSearchCriteria criteria);
}
