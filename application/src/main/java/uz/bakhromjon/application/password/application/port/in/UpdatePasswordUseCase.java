package uz.bakhromjon.application.password.application.port.in;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Normalized;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;

public interface UpdatePasswordUseCase {
    PasswordResponse update(PasswordUpdateRequest updateRequest);

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    class PasswordUpdateRequest {
        private String name;
        private String username;
        @NotBlank
        private String password;
        private String notes;
    }
}
