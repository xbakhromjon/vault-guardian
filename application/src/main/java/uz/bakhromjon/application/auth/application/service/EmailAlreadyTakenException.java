package uz.bakhromjon.application.auth.application.service;

import lombok.Getter;
import uz.bakhromjon.application.common.Error;
import uz.bakhromjon.common.ErrorData;
import uz.bakhromjon.common.UserException;

@Getter
public class EmailAlreadyTakenException extends UserException {

    public EmailAlreadyTakenException(String message, ErrorData data) {
        super(message, 400, Error.EMAIL_ALREADY_TAKEN.getCode(), data);
    }
}
