package uz.bakhromjon.application.password.application.port.in;

import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.password.application.port.in.criteria.PasswordSearchCriteria;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;

public interface GetPasswordQuery {
    PasswordResponse getById(Password.PasswordId id);

    PageableResponse<PasswordResponse> search(PasswordSearchCriteria criteria);
}
