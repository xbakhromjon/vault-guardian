package uz.bakhromjon.persistence.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import uz.bakhromjon.persistence.user.UserDocument;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "access_token")
public class AccessTokenDocument {
    @Id
    private String token;

    private LocalDateTime expireAt;

    private UserDocument user;
}
