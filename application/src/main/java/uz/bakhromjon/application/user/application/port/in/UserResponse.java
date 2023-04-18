package uz.bakhromjon.application.user.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.application.user.domain.User;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private User.UserId id;
    private String email;
}
