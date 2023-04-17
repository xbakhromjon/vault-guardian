package uz.bakhromjon.application.password.application.port.in;

import uz.bakhromjon.application.password.domain.Password;

public interface DeletePasswordUseCase {
    boolean delete(Password.PasswordId id);
}
