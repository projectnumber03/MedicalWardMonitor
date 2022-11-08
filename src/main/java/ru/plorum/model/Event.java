package ru.plorum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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

    @JsonProperty
    String zone;

    @JsonProperty
    Department department;

    @JsonProperty
    String date;

    @JsonProperty
    Integer bed;

    public Event(
            final UUID id,
            final Patient patient,
            final String zone,
            final Department department,
            final String date,
            final Integer bed
    ) {
        this.id = id;
        this.patient = patient;
        this.zone = zone;
        this.department = department;
        this.date = date;
        this.bed = bed;
    }

}

