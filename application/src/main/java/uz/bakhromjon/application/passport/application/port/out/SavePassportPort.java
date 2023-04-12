package uz.bakhromjon.application.passport.application.port.out;

import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.application.password.domain.Password;

public interface SavePassportPort {
    Passport save(Passport passport);
}
