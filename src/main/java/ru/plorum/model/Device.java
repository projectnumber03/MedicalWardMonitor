package ru.plorum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Device {

    UUID id;

    String name;

    Status status = Status.ACTIVE;

    String description;

    LocalDateTime creationDate;

    LocalDateTime archivingDate;

    String ip;

    Integer pin;

    DeviceType type;

    Bed bed;

    LocalDateTime lastEventDate;

    LocalDateTime lastHealthCheckDate;

    @JsonProperty
    Integer healthCheckTimeout = 60;

    String location;

    boolean ping;

    public enum Status {
        ACTIVE, ARCHIVE
    }

}
