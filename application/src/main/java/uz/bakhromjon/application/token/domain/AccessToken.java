package uz.bakhromjon.application.token.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.application.common.ApplicationConstant;
import uz.bakhromjon.application.common.BaseUtils;
import uz.bakhromjon.application.user.domain.User;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class AccessToken {
    // TODO: 3/3/2023 SOMEONE (P1): Default qiymatlar qayerda bo'lishi kerak ?!
    private String token = BaseUtils.generateUniqueString(30);
    private User user;
    private LocalDateTime expireAt = LocalDateTime.now().plusSeconds(ApplicationConstant.ACCESS_TOKEN_EXPIRATION_IN_SECOND);
    private Boolean isDeleted = Boolean.FALSE;

    public static AccessToken create(User user) {
        AccessToken accessToken = new AccessToken();
        accessToken.setUser(user);
        return accessToken;
    }

    public boolean isExpired() {
        return this.expireAt.isBefore(LocalDateTime.now());
    }

}
