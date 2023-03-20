package uz.bakhromjon.app.application;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "application")
public class ApplicationJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long applicantId;

    @Column(columnDefinition = "varchar(1000)")
    private String message;

    @Column
    private Boolean isDeleted = Boolean.FALSE;
}
