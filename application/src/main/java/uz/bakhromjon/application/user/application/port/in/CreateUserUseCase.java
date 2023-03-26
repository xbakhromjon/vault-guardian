package uz.bakhromjon.application.user.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.bakhromjon.application.user.domain.User;

public interface CreateUserUseCase {
    User create(UserCreateRequest createRequest);

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = {"email", "masterPassword"}, callSuper = false)
    class UserCreateRequest {
        @NotNull
        private String email;

        @NotBlank
        private String masterPassword;

        private String hint;
    }
}
