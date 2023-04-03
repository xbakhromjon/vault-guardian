package uz.bakhromjon.application.password.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class Password {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private String username;
    private String password;
    private String notes;


    public Password(String name, String username, String password, String notes) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.notes = notes;
    }
}
