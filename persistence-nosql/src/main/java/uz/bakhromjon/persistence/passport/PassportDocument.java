package uz.bakhromjon.persistence.passport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uz.bakhromjon.persistence.common.Auditable;
import uz.bakhromjon.persistence.user.UserDocument;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class PassportDocument extends Auditable {
    @Id
    private Long id;

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

    private UserDocument owner;
}
