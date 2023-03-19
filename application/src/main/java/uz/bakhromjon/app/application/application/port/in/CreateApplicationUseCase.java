package uz.bakhromjon.app.application.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import uz.bakhromjon.app.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.app.common.SelfValidating;

public interface CreateApplicationUseCase {
    ApplicationResponse execute(ApplicationCreateRequest createRequest);


    @Getter
    class ApplicationCreateRequest extends SelfValidating<CreateApplicationUseCase.ApplicationCreateRequest> {
        @NotNull
        private final Long applicantId;

        @NotBlank
        private final String message;


        public ApplicationCreateRequest(Long applicantId, String message) {
            this.applicantId = applicantId;
            this.message = message;
            this.validateSelf();
        }
    }


}
