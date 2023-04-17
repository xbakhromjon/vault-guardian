package uz.bakhromjon.persistence.password;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import uz.bakhromjon.persistence.common.Auditable;
import uz.bakhromjon.persistence.common.BaseEntity;
import uz.bakhromjon.persistence.user.UserJpaEntity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "password")
@SQLDelete(sql = "UPDATE password SET is_deleted = true where id = ?")
@Where(clause = "not is_deleted")
@Indexed
public class PasswordJpaEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FullTextField
    private String name;

    @FullTextField
    private String username;

    private String password;

    @FullTextField
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserJpaEntity owner;
}
