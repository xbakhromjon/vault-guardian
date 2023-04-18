package uz.bakhromjon.application.passport.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import uz.bakhromjon.application.passport.domain.Passport;

import java.time.LocalDate;

public interface UpdatePassportUseCase {
    PassportResponse update(PassportUpdateRequest updateRequest);

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    class PassportUpdateRequest {
        private Passport.PassportId id;
        private String name;
        private String country;
        @NotNull
        @NotBlank
        private String number;
        private String sex;
        private String nationality;
        private String issuingAuthority;
        private LocalDate dateOfBirth;
        private LocalDate issuedDate;
        private LocalDate expirationDate;
        private String notes;
    }
}
