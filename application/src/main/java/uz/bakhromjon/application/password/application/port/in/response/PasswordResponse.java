package uz.bakhromjon.application.password.application.port.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.application.password.domain.Password;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResponse {
    private Password.PasswordId id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private String username;
    private String password;
    private String notes;
}
