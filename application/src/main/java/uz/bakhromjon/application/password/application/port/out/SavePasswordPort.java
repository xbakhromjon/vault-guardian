package uz.bakhromjon.application.password.application.port.out;

import uz.bakhromjon.application.password.domain.Password;

public interface SavePasswordPort {
    Password save(Password password);
}