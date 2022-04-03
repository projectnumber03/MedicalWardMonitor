package ru.plorum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public final class Event {

    @EqualsAndHashCode.Exclude
    UUID alertId;

    @JsonProperty
    UUID id;

    @JsonProperty
    Department department;

    @JsonProperty
    Zone zone;

    @JsonProperty
    Bed bed;

    @JsonProperty
    Patient patient;

    @JsonProperty
    String date;

    @JsonProperty
    Staff staff;

    @JsonProperty
    Device device;

    @JsonProperty
    Boolean isSound;

    @JsonProperty
    String deviceName;

    Type type;

    @Getter
    @AllArgsConstructor
    public enum Type {
        ALERT(Role.PATIENT, "Вызов"),
        HEALTHCHECK(Role.DEVICE, "Проверка состояния"),
        BED_DETACHING(Role.STAFF, "Отвязка койки"),
        ZONE_DETACHING(Role.STAFF, "Отвязка палаты"),
        CLOSE_ALERT(Role.STAFF, "Завершение вызова");

        private final Role role;

        private final String name;

    }

    @Getter
    @AllArgsConstructor
    public enum Role {
        PATIENT("Пациент"),
        DEVICE("Устройство"),
        STAFF("Персонал");

        private final String name;

    }

}

