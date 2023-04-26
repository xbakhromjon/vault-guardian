package uz.bakhromjon.persistence.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public abstract class Auditable {
    private String sequenceName;
    private Long id;
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
