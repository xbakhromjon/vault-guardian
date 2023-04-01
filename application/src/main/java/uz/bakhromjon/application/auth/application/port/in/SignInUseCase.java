package uz.bakhromjon.application.auth.application.port.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import uz.bakhromjon.application.auth.application.service.BadCredentialsException;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;

public interface SignInUseCase {
    AccessTokenResponse signIn(SignInRequest signInRequest) throws BadCredentialsException;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = {"email", "masterPassword"}, callSuper = false)
    class SignInRequest {
        @NotNull
        @Email
        private String email;

        @NotBlank
        private String masterPassword;
    }
}
