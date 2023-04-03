package uz.bakhromjon.application.password.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;

public interface UpdatePasswordUseCase {
    PasswordResponse update(PasswordUpdateRequest updateRequest);

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    class PasswordUpdateRequest {
        @NotNull
        private Long id;
        private String name;
        private String username;
        @NotBlank
        private String password;
        private String notes;
    }
}
