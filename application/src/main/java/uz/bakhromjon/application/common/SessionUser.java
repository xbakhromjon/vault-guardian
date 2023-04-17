package uz.bakhromjon.application.common;

import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.ERole;

import java.util.Collection;

public interface SessionUser {
    User.UserId getId();

    String getEmail();

    String getMasterPassword();

    String getHint();

    ERole getRole();
}
