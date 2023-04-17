package uz.bakhromjon.application.password.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.application.password.domain.Password;

public interface UpdatePasswordUseCase {
    PasswordResponse update(PasswordUpdateRequest updateRequest);

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    class PasswordUpdateRequest {
        @NotNull
        private Password.PasswordId id;
        private String name;
        private String username;
        @NotBlank
        private String password;
        private String notes;
    }
}
