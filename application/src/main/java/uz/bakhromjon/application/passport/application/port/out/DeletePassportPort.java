package uz.bakhromjon.application.passport.application.port.out;

import uz.bakhromjon.application.passport.domain.Passport;

public interface DeletePassportPort {
    void deleteById(Passport.PassportId passportId);
}
