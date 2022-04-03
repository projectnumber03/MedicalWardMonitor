package ru.plorum.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Zone {

    UUID id;

    String name;

    Status status = Status.ACTIVE;

    String description;

    @NonNull
    List<Bed> beds = new ArrayList<>();

    Integer floor;

    Department department;

    LocalDateTime creationDate;

    Integer patientsAmount = 0;

    String occupancy;

    public enum Status {
        ACTIVE, OUT_OF_SERVICE
    }

}
