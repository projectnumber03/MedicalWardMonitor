package ru.plorum.service;

import ru.plorum.model.Event;
import ru.plorum.model.Patient;
import ru.plorum.repository.EventRepository;
import ru.plorum.repository.PatientRepository;

import java.util.Collections;
import java.util.List;

public enum EventService {

    INSTANCE;

    public List<Event> getAll() {
        try {
            final List<Event> events = EventRepository.INSTANCE.getAll();
            PatientRepository.INSTANCE.getAll().stream()
                    .filter(p -> events.stream().map(Event::getPatient).map(Patient::getId).noneMatch(p.getId()::equals))
                    .forEach(p -> events.add(new Event(null, new Patient(p.getId(), p.getFio()))));
            return events;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
