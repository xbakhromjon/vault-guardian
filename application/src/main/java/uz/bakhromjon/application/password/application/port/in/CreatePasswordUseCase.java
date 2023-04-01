package uz.bakhromjon.application.password.application.port.in;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;

public interface CreatePasswordUseCase {
    PasswordResponse create(PasswordCreateRequest createRequest);

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    class PasswordCreateRequest {
        private String name;
        private String username;
        @NotBlank
        private String password;
        private String notes;
    }
}
