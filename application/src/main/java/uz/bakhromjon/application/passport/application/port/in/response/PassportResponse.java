package uz.bakhromjon.application.passport.application.port.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.application.passport.domain.Passport;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassportResponse {
    private Passport.PassportId id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private String country;
    private String number;
    private String sex;
    private String nationality;
    private String issuingAuthority;
    private String datOfBirth;
    private String issuedDate;
    private String expirationDate;
    private String notes;
}
