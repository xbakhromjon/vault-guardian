package uz.bakhromjon.app.application.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.common.SelfValidating;

public interface UpdateApplicationUseCase {
    ApplicationResponse execute(ApplicationUpdateRequest updateRequest);


    @Getter
    @NoArgsConstructor
    class ApplicationUpdateRequest extends SelfValidating<ApplicationUpdateRequest> {
        @NotNull
        private Long id;
        @NotBlank
        private String message;

        public ApplicationUpdateRequest(Long id, String message) {
            this.id = id;
            this.message = message;
            this.validateSelf();
        }
    }
}
