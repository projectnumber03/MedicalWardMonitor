package ru.plorum.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class AccessCard {

    UUID id;

    String name;

    Status status = Status.ACTIVE;

    String description;

    LocalDateTime creationDate;

    LocalDateTime blockingDate;

    Staff staff;

    public enum Status {
        ACTIVE, BLOCKED
    }

}
