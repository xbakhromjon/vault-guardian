package uz.bakhromjon.application.user.application.port.out;

import uz.bakhromjon.application.user.domain.User;

public interface LoadUserPort {
    User loadByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(User.UserId userId);
}
