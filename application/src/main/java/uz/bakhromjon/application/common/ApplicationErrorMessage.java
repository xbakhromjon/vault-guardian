package uz.bakhromjon.application.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApplicationErrorMessage {
    public static final String EMAIL_ALREADY_TAKEN = "email_already_taken";
    public static final String BAD_CREDENTIALS = "bad_credentials";
    public static final String UNKNOWN_ENCRYPTION_ERROR = "unknown_encryption_error";
    public static final String UNKNOWN_DECRYPTION_ERROR = "unknown_decryption_error";
}
