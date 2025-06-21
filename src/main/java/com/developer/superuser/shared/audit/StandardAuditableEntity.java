package com.developer.superuser.shared.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, setterPrefix = "set")
@EqualsAndHashCode
@ToString(callSuper = true)
public abstract class StandardAuditableEntity {
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    protected Instant createdAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 100)
    protected String createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected Instant updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by", length = 100)
    protected String updatedBy;

    @Column(name = "deleted")
    protected boolean deleted;

    @Column(name = "deleted_at")
    protected Instant deletedAt;

    @Column(name = "deleted_by", length = 100)
    protected String deletedBy;

    @Version
    @Column(name = "version", nullable = false)
    protected Long version;
}