package uz.bakhromjon.persistence.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PersistenceErrorDataKey {
    public final static String APPLICATION_ID = "application_id";
    public static final String USER_EMAIL = "user_email";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String PASSWORD_ID = "password_id";
}
