package vn.hoangptit.tiger.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Serializable {
    @Column(name = "created_user", nullable = false, updatable = false)
    @CreatedBy
    private String createdUser;

    @Column(name = "created_datetime", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDatetime;

    @Column(name = "updated_user", nullable = false, updatable = false)
    @LastModifiedBy
    private String updatedUser;

    @Column(name = "updated_datetime", nullable = false, updatable = false)
    @LastModifiedDate
    private LocalDateTime updatedDatetime;
}
