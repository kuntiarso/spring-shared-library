package com.developer.superuser.shared.audit;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, setterPrefix = "with")
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public abstract class StandardAuditable {
    protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
    protected boolean deleted = false;
    protected Instant deletedAt;
    protected String deletedBy;
    protected Long version;
}