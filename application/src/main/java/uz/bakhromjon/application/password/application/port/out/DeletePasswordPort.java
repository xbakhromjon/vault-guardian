package uz.bakhromjon.application.password.application.port.out;

import uz.bakhromjon.application.password.domain.Password;

public interface DeletePasswordPort {
    void deleteById(Password.PasswordId id);
}
