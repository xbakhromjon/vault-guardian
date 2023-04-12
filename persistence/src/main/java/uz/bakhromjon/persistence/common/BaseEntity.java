package uz.bakhromjon.persistence.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

public interface BaseEntity {
    Auditor getAuditor();
}
