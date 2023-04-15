package uz.bakhromjon.application.password.application.port.in;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;

public interface CreatePasswordUseCase {
    PasswordResponse create(PasswordCreateRequest createRequest);

    @Getter
    @Setter
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
