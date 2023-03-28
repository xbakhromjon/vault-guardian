package uz.bakhromjon.application.token.application.port.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.application.common.ApplicationConstants;
import uz.bakhromjon.application.common.BaseUtils;
import uz.bakhromjon.application.user.domain.User;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResponse {
    private String token;
    private LocalDateTime expireAt;
}
