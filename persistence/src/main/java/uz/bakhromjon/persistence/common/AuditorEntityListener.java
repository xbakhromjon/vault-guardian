package uz.bakhromjon.persistence.common;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class AuditorEntityListener {
    // TODO: 4/9/2023 sessionId
    @PrePersist
    public void persist(BaseEntity entity) {
        Auditor auditor = entity.getAuditor();
        if (auditor != null) {
            auditor.setCreatedBy(-1L);
            auditor.setCreatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void update(BaseEntity entity) {
        Auditor auditor = entity.getAuditor();
        if (auditor != null) {
            auditor.setUpdatedBy(-1L);
            auditor.setUpdatedAt(LocalDateTime.now());
        }
    }
}
