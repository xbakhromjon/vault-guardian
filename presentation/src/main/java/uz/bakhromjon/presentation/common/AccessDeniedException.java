package uz.bakhromjon.presentation.common;

import org.springframework.http.HttpStatus;
import uz.bakhromjon.common.ClientException;
import uz.bakhromjon.common.ErrorData;

public class AccessDeniedException extends ClientException {
    public AccessDeniedException(String message, ErrorData data) {
        super(message, HttpStatus.FORBIDDEN.value(), data);
    }
}
