package uz.bakhromjon.application.common;

import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.ERole;

public interface SessionUser {
    User.UserId getId();

    String getEmail();

    String getMasterPassword();

    String getHint();

    ERole getRole();

}
