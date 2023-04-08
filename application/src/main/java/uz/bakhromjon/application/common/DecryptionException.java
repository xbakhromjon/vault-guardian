package uz.bakhromjon.application.common;

import uz.bakhromjon.common.ApplicationException;
import uz.bakhromjon.common.ErrorData;

public class DecryptionException extends ApplicationException {
    public DecryptionException(String message) {
        super(message, 500, null);
    }
}
