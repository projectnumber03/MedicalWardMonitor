package ru.plorum.repository;

import com.hazelcast.jet.datamodel.Tuple2;
import com.hazelcast.jet.datamodel.Tuple4;
import ru.plorum.model.Patient;
import ru.plorum.service.PropertiesService;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public enum PatientRepository {

    INSTANCE;

    public List<Patient> getAll() {
        final String zoneName = new String(PropertiesService.INSTANCE.getString("zone.name").getBytes(StandardCharsets.ISO_8859_1));
        return HazelcastRepository.INSTANCE.getDeviceZonePatientDepartmentCache().entrySet().stream()
                .filter(entry -> zoneName.equals(entry.getValue().f0().f1()))
                .map(entry -> createPatient(entry.getKey()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Patient createPatient(final UUID id) {
        final Tuple4<Tuple2<UUID, String>, Tuple2<UUID, String>, Tuple2<UUID, String>, Tuple2<UUID, Integer>> data = HazelcastRepository.INSTANCE.getDeviceZonePatientDepartmentCache().get(id);
        if (Objects.isNull(data)) return null;
        final Tuple2<UUID, String> patientData = data.f1();
        if (Objects.isNull(patientData)) return null;
        return new Patient(patientData.f0(), patientData.f1());
    }

}
