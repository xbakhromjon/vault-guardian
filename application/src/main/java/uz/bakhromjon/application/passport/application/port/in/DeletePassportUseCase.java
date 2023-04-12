package uz.bakhromjon.application.passport.application.port.in;

import uz.bakhromjon.application.passport.domain.Passport;

public interface DeletePassportUseCase {
    void delete(Passport.PassportId id);
}
