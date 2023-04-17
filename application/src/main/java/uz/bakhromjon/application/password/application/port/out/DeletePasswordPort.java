package uz.bakhromjon.application.password.application.port.out;

import uz.bakhromjon.application.password.domain.Password;

public interface DeletePasswordPort {
    boolean deleteById(Password.PasswordId id);
}
