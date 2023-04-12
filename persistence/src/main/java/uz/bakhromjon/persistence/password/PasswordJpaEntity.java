package uz.bakhromjon.persistence.password;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import uz.bakhromjon.persistence.common.Auditor;
import uz.bakhromjon.persistence.common.AuditorEntityListener;
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
@EntityListeners(AuditorEntityListener.class)
@Indexed
public class PasswordJpaEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Auditor auditor;

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
