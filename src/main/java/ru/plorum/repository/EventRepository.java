package ru.plorum.repository;

import ru.plorum.model.Event;
import ru.plorum.util.ObjectMapper;
import ru.plorum.util.WebClient;

import java.util.List;

public enum EventRepository {

    INSTANCE;

    public List<Event> getAll() throws Exception {
        final String body = WebClient.INSTANCE.get("/draw-alerts");
        return new ObjectMapper().readValue(body);
    }

}
