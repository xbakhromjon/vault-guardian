package uz.bakhromjon.persistence.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uz.bakhromjon.common.ERole;
import uz.bakhromjon.persistence.common.Auditable;
import uz.bakhromjon.persistence.passport.PassportDocument;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UserDocument extends Auditable {
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private Long id;

    private String email;

    private String masterPassword;

    private String hint;

    private ERole role;

    @Override
    public String getSequenceName() {
        return SEQUENCE_NAME;
    }
}
