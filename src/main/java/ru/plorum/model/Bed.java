package ru.plorum.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.UUID;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Bed {

    UUID id;

    Integer number;

    public Bed(Integer number) {
        this.id = UUID.randomUUID();
        this.number = number;
    }

    @Override
    public String toString() {
        return "Койка №" + this.number;
    }

}
