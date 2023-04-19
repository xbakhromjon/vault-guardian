package uz.bakhromjon.persistence.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.common.ERole;
import uz.bakhromjon.persistence.passport.PassportJpaEntity;
import uz.bakhromjon.persistence.password.PasswordJpaEntity;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String masterPassword;

    @Column
    private String hint;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ERole role;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<PassportJpaEntity> passports;
}
