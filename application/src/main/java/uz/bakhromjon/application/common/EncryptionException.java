package uz.bakhromjon.application.common;

import uz.bakhromjon.common.ApplicationException;

public class EncryptionException extends ApplicationException {
    public EncryptionException(String message) {
        super(message, 500, null);
    }
}
