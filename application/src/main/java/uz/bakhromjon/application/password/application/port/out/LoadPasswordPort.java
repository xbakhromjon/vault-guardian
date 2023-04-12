package uz.bakhromjon.application.password.application.port.out;

import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.password.application.port.in.criteria.PasswordSearchCriteria;
import uz.bakhromjon.application.password.domain.Password;
import uz.bakhromjon.application.user.domain.User;

public interface LoadPasswordPort {
    Password load(Password.PasswordId id, User.UserId requestedUserId);

    PageableResponse<Password> search(PasswordSearchCriteria criteria);
}
