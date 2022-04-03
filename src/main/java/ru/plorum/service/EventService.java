package ru.plorum.service;

import ru.plorum.model.Event;
import ru.plorum.repository.EventRepository;

import java.util.Collections;
import java.util.List;

public enum EventService {

    INSTANCE;

    public List<Event> getAll() {
        try {
            return EventRepository.INSTANCE.getAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
