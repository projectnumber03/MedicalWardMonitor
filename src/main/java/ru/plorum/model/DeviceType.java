package ru.plorum.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class DeviceType {

    UUID id;

    String name;

    String description;

    Status status = Status.ACTIVE;

    DeviceCategory category;

    LocalDateTime creationDate;

    LocalDateTime archivingDate;

    public enum Status {
        ACTIVE, ARCHIVE
    }

}
