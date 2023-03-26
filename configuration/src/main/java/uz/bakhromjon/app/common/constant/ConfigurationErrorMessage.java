package uz.bakhromjon.app.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigurationErrorMessage {

    public static final String ACCESS_TOKEN_REQUIRED_THIS_RESOURCE = "access_token_required_this_resource";
    public static final String WRONG_ACCESS_TOKEN = "wrong_access_token";
    public static final String ACCESS_TOKEN_EXPIRED = "access_token_expired";
}
