package uz.bakhromjon.persistence.token;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.persistence.user.UserJpaEntity;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "access_token")
public class AccessTokenJpaEntity {
    // TODO: 3/3/2023 BAKHROMJON (P1): refresh token qo'shish kerak
    @Id
    private String token;

    @Column(nullable = false)
    private LocalDateTime expireAt;

    @ManyToOne
    private UserJpaEntity user;
}
