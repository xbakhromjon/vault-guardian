package uz.bakhromjon.application.passport.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.cglib.core.Local;
import uz.bakhromjon.application.passport.application.port.in.response.PassportResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CreatePassportUseCase {
    PassportResponse create(PassportCreateRequest createRequest);

    @Setter
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
        private LocalDate dateOfBirth;
        private LocalDate issuedDate;
        private LocalDate expirationDate;
        private String notes;
    }
}
