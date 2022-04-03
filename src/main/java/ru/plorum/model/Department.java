package ru.plorum.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Department {

    UUID id;

    String name;

    Status status = Status.ACTIVE;

    String description;

    LocalDateTime creationDate;

    LocalDateTime archivingDate;

    Long staffAmount;

    Long patientsAmount;

    Long deviceAmount;

    public enum Status {
        ACTIVE, ARCHIVE
    }

}
