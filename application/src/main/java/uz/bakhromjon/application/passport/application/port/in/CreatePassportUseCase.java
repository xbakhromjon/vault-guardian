package uz.bakhromjon.application.passport.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.bakhromjon.application.passport.application.port.in.response.PassportResponse;

public interface CreatePassportUseCase {
    PassportResponse create(PassportCreateRequest createRequest);

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    class PassportCreateRequest {
        private String name;
        private String country;
        @NotNull
        @NotBlank
        private String number;
        private String sex;
        private String nationality;
        private String issuingAuthority;
        private String dateOfBirth;
        private String issuedDate;
        private String expirationDate;
        private String notes;
    }
}
