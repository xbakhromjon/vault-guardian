package uz.bakhromjon.application.auth.application.port.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import uz.bakhromjon.application.auth.application.service.EmailAlreadyTakenException;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;

public interface SignUpUseCase {
    AccessTokenResponse signup(SignupRequest signUpRequest) throws EmailAlreadyTakenException;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = {"email", "masterPassword", "hint"}, callSuper = false)
    class SignupRequest {
        @NotNull
        @Email
        private String email;

        @NotBlank
        private String masterPassword;

        private String hint;
    }
}
