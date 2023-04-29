package uz.bakhromjon.persistence.password;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uz.bakhromjon.persistence.common.Auditable;
import uz.bakhromjon.persistence.user.UserDocument;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "password")
public class PasswordDocument extends Auditable {
    public static final String SEQUENCE_NAME = "password_sequence";
    @Id
    private Long id;

    private String name;

    private String username;

    private String password;

    private String notes;

    private UserDocument owner;

    @Override
    public String getSequenceName() {
        return SEQUENCE_NAME;
    }
}
