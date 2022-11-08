package ru.plorum.repository;

import com.hazelcast.jet.datamodel.Tuple2;
import lombok.extern.log4j.Log4j2;
import ru.plorum.model.Event;
import ru.plorum.service.PropertiesService;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
public enum EventRepository {

    INSTANCE;

    public List<Event> getAll() {
        final Map<UUID, LocalDateTime> alerts = HazelcastRepository.INSTANCE.getHazelcastInstance().getMap("alerts");
        final String zoneName = new String(PropertiesService.INSTANCE.getString("zone.name").getBytes(StandardCharsets.ISO_8859_1));
        final List<Event> events = alerts.entrySet().stream()
                .filter(entry -> zoneName.equals(Optional.ofNullable(HazelcastRepository.INSTANCE.getDeviceZonePatientDepartmentCache().get(entry.getKey()).f0()).map(Tuple2::getValue).orElse(null)))
                .map(entry -> new Event(entry.getKey(), PatientRepository.INSTANCE.createPatient(entry.getKey()), zoneName, DepartmentRepository.INSTANCE.createDepartment(entry.getKey()), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(entry.getValue()), Optional.ofNullable(HazelcastRepository.INSTANCE.getDeviceZonePatientDepartmentCache().get(entry.getKey()).f3()).map(Tuple2::getValue).orElse(null)))
                .collect(Collectors.toList());
        log.info("{} events for zone {}:", events.size(), zoneName);
        events.forEach(log::info);
        return events;
    }

}
