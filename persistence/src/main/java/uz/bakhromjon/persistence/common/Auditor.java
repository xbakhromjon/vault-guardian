package uz.bakhromjon.persistence.common;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class Auditor {
    @CreatedBy
    private Long createdBy;
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedBy
    private Long updatedBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private boolean isDeleted;
}
