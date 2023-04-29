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
@Document(collection = "passport")
public class PassportDocument extends Auditable {
    public static final String SEQUENCE_NAME = "passport_sequence";
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


    @Override
    public String getSequenceName() {
        return SEQUENCE_NAME;
    }
}
