package ru.plorum.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Deque;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedDeque;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Patient {

    UUID id;

    String fio;

    String login;

    Department department;

    @Setter(AccessLevel.NONE)
    Zone zone;

    @Setter(AccessLevel.NONE)
    Bed bed;

    Status status = Status.DETACHED;

    LocalDateTime creationDate;

    String description;

    @ToString.Exclude
    Deque<Event> events = new ConcurrentLinkedDeque<>();

    public enum Status {
        ATTACHED,  //в палате
        DETACHED,  //без палаты
        DISCHARGED //выписавшийся
    }

}
