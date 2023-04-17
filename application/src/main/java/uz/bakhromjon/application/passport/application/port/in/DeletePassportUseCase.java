package uz.bakhromjon.application.passport.application.port.in;

import uz.bakhromjon.application.passport.domain.Passport;

public interface DeletePassportUseCase {
    boolean delete(Passport.PassportId id);
}
