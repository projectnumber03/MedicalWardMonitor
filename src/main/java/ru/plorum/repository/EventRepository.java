package ru.plorum.repository;

import ru.plorum.model.Event;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public enum EventRepository {

    INSTANCE;

    public List<Event> getAll() {
        final Map<UUID, LocalDateTime> alerts = HazelcastRepository.INSTANCE.getHazelcastInstance().getMap("alerts");
        return alerts.keySet().stream().map(localDateTime -> new Event(localDateTime, PatientRepository.INSTANCE.createPatient(localDateTime))).collect(Collectors.toList());
    }

}
