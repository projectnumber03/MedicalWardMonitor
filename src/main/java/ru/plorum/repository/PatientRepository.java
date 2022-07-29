package ru.plorum.repository;

import com.hazelcast.jet.datamodel.Tuple2;
import ru.plorum.model.Patient;
import ru.plorum.service.PropertiesService;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public enum PatientRepository {

    INSTANCE;

    public List<Patient> getAll() {
        final String zoneName = new String(PropertiesService.INSTANCE.getString("zone.name").getBytes(StandardCharsets.ISO_8859_1));
        return getDeviceZonePatientCache().entrySet().stream()
                .filter(entry -> zoneName.equals(entry.getValue().f0().f1()))
                .map(entry -> createPatient(entry.getKey()))
                .collect(Collectors.toList());
    }

    public Patient createPatient(final UUID id) {
        final Tuple2<UUID, String> patientData = getDeviceZonePatientCache().get(id).f1();
        return new Patient(patientData.f0(), patientData.f1());
    }

    private Map<UUID, Tuple2<Tuple2<UUID, String>, Tuple2<UUID, String>>> getDeviceZonePatientCache() {
        return HazelcastRepository.INSTANCE.getHazelcastInstance().getMap("deviceZonePatientCache");
    }

}
