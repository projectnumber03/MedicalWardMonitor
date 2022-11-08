package ru.plorum.service;

import lombok.extern.log4j.Log4j2;
import ru.plorum.model.Event;
import ru.plorum.repository.EventRepository;

import java.util.Collections;
import java.util.List;

@Log4j2
public enum EventService {

    INSTANCE;

    public List<Event> getAll() {
        try {
            return EventRepository.INSTANCE.getAll();
        } catch (Exception e) {
            log.info("no alerts", e);
            return Collections.emptyList();
        }
    }

}
