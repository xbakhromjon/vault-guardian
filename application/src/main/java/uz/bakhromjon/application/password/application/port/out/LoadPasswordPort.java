package uz.bakhromjon.application.password.application.port.out;

import uz.bakhromjon.application.password.domain.Password;

public interface LoadPasswordPort {
    Password load(long passwordId, long requestedUserId);
}
