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
    Patient patient;

    public Event(UUID id, Patient patient) {
        this.id = id;
        this.patient = patient;
    }

}

