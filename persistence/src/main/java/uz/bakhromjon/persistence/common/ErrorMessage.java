package uz.bakhromjon.persistence.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessage {
    public final static String APPLICATION_NOT_FOUND = "application_not_found";
    public static final String USER_NOT_FOUND = "user_not_found";
    public static final String ACCESS_TOKEN_NOT_FOUND = "access_token_not_found";
}
