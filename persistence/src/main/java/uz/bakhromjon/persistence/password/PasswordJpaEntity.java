package uz.bakhromjon.persistence.password;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.bakhromjon.persistence.user.UserJpaEntity;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "password")
@SQLDelete(sql = "UPDATE password SET is_deleted = true where id = ?")
@Where(clause = "not is_deleted")
public class PasswordJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isDeleted;

    private String name;
    private String username;
    private String password;
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserJpaEntity owner;
}
