package ru.plorum.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Staff {

    UUID id;

    String fio;

    String login;

    String password;

    String description;

    Status status = Status.ACTIVE;

    LocalDateTime creationDate;

    LocalDateTime blockingDate;

    Role role;

    Department department;

    boolean sound = false;

    List<AccessCard> accessCards = new ArrayList<>();

    public enum Status {
        ACTIVE, BLOCKED
    }

}
