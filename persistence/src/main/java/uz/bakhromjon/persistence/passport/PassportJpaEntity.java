package uz.bakhromjon.persistence.passport;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import uz.bakhromjon.persistence.common.Auditor;
import uz.bakhromjon.persistence.common.AuditorEntityListener;
import uz.bakhromjon.persistence.common.BaseEntity;
import uz.bakhromjon.persistence.user.UserJpaEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passport")
@SQLDelete(sql = "UPDATE passport SET is_deleted = true where id = ?")
@Where(clause = "not is_deleted")
@EntityListeners(AuditorEntityListener.class)
@Indexed
public class PassportJpaEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Auditor auditor;

    @FullTextField
    private String name;
    private String country;

    @FullTextField
    @Column(nullable = false)
    private String number;
    private String sex;
    private String nationality;
    private LocalDate issuingAuthority;
    private LocalDate dateOfBirth;
    private LocalDate issuedDate;
    private String expirationDate;

    @FullTextField
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserJpaEntity owner;
}
