package uz.bakhromjon.application.application.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.bakhromjon.application.application.application.port.in.response.ApplicationResponse;
import uz.bakhromjon.common.SelfValidating;

public interface CreateApplicationUseCase {
    ApplicationResponse execute(ApplicationCreateRequest createRequest);


    @Getter
    @NoArgsConstructor
    @EqualsAndHashCode(of = {"applicantId", "message"}, callSuper = false)
    class ApplicationCreateRequest extends SelfValidating<CreateApplicationUseCase.ApplicationCreateRequest> {
        @NotNull
        private Long applicantId;

        @NotBlank
        private String message;


        public ApplicationCreateRequest(Long applicantId, String message) {
            this.applicantId = applicantId;
            this.message = message;
            this.validateSelf();
        }
    }


}
