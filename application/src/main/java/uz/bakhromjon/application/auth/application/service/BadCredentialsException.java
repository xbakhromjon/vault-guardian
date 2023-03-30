package uz.bakhromjon.application.auth.application.service;

import lombok.Getter;
import uz.bakhromjon.application.common.Error;
import uz.bakhromjon.common.ErrorData;
import uz.bakhromjon.common.UserException;

@Getter
public class BadCredentialsException extends UserException {

    public BadCredentialsException(String message, ErrorData data) {
        super(message, 400, Error.BAD_CREDENTIALS.getCode(), data);
    }

    public BadCredentialsException(String message) {
        super(message, 400, Error.BAD_CREDENTIALS.getCode(), null);
    }
}
