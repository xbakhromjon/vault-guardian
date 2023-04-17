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
import uz.bakhromjon.persistence.common.Auditable;
import uz.bakhromjon.persistence.common.BaseEntity;
import uz.bakhromjon.persistence.user.UserJpaEntity;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passport")
@SQLDelete(sql = "UPDATE passport SET is_deleted = true where id = ?")
@Where(clause = "not is_deleted")
@Indexed
public class PassportJpaEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FullTextField
    private String name;
    private String country;

    @FullTextField
    @Column(nullable = false)
    private String number;
    private String sex;
    private String nationality;
    private String issuingAuthority;
    private LocalDate dateOfBirth;
    private LocalDate issuedDate;
    private LocalDate expirationDate;

    @FullTextField
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserJpaEntity owner;
}
