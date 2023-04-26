package uz.bakhromjon.application.user.domain;

import lombok.*;
import uz.bakhromjon.common.ERole;

import java.beans.Transient;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "email", "masterPassword", "hint"})
public class User {

    private UserId id;
    private String email;
    private String masterPassword;
    private String hint;
    private ERole role;

    public User(String email, String masterPassword, String hint) {
        this.email = email;
        this.masterPassword = masterPassword;
        this.hint = hint;
    }


    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserId {
        private Long value;
    }
}
