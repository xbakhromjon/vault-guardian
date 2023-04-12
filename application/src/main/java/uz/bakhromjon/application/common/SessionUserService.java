package uz.bakhromjon.application.common;

import uz.bakhromjon.application.user.domain.User;

public interface SessionUserService {
    SessionUser getSession();

    User.UserId getSessionId();
}
