package uz.bakhromjon.application.passport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import uz.bakhromjon.application.user.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class Passport {
    private PassportId id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;

    private String name;
    private String country;
    private String number;
    private String sex;
    private String nationality;
    private String issuingAuthority;
    private LocalDate dateOfBirth;
    private LocalDate issuedDate;
    private LocalDate expirationDate;
    private String notes;

    private User.UserId ownerId;


    public Passport(String name, String country, String number, String sex, String nationality, String issuingAuthority, LocalDate dateOfBirth, LocalDate issuedDate, LocalDate expirationDate, String notes) {
        this.name = name;
        this.country = country;
        this.number = number;
        this.sex = sex;
        this.nationality = nationality;
        this.issuingAuthority = issuingAuthority;
        this.dateOfBirth = dateOfBirth;
        this.issuedDate = issuedDate;
        this.expirationDate = expirationDate;
        this.notes = notes;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PassportId {
        private Long value;
    }
}
