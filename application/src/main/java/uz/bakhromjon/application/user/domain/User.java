package uz.bakhromjon.application.user.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "email", "masterPassword", "hint"})
public class User {
    private Long id;
    private String email;
    private String masterPassword;
    private String hint;

    public User(String email, String masterPassword, String hint) {
        this.email = email;
        this.masterPassword = masterPassword;
        this.hint = hint;
    }
}
