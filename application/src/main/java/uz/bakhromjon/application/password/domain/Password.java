package uz.bakhromjon.application.password.domain;

import lombok.*;
import uz.bakhromjon.application.user.domain.User;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class Password {

    private PasswordId id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;
    private String name;
    private String username;
    private String password;
    private String notes;

    private User.UserId ownerId;


    public Password(String name, String username, String password, String notes) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.notes = notes;
    }


    @Value
    public static class PasswordId {
        private Long value;
    }
}
