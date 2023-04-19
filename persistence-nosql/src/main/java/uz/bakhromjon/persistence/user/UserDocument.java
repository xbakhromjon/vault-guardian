package uz.bakhromjon.persistence.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uz.bakhromjon.common.ERole;
import uz.bakhromjon.persistence.passport.PassportDocument;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserDocument {
    @Id
    private Long id;

    private String email;

    private String masterPassword;

    private String hint;

    private ERole role;

    private List<PassportDocument> passports;
}
