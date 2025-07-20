package com.developer.superuser.shared.audit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, setterPrefix = "set")
@EqualsAndHashCode
@ToString(callSuper = true)
public abstract class StandardAuditable {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Instant createdAt;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String createdBy;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Instant updatedAt;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String updatedBy;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected boolean deleted = false;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Instant deletedAt;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String deletedBy;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected Long version;
}