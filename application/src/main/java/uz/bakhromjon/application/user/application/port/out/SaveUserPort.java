package uz.bakhromjon.application.user.application.port.out;

import uz.bakhromjon.application.user.domain.User;

public interface SaveUserPort {
    User save(User user);
}
