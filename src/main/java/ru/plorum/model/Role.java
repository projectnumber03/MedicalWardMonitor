package ru.plorum.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import spark.utils.StringUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Role {

    UUID id;

    String name;

    Role.Status status = Role.Status.ACTIVE;

    String description;

    LocalDateTime creationDate;

    LocalDateTime archivingDate;

    public enum Status {
        ACTIVE, ARCHIVE
    }

    public Role setName(final String name) {
        final String prefix = "ROLE_";
        if (StringUtils.hasLength(name) && !name.startsWith(prefix)) {
            this.name = prefix + name;
            return this;
        }
        this.name = name;
        return this;
    }

}
