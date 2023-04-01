package uz.bakhromjon.application.password.application.port.in;

import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;

public interface GetPasswordQuery {
    PasswordResponse getById(long id);

    PageableResponse<PasswordResponse> search(String search);
}
