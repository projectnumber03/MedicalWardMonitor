package ru.plorum.repository;

import com.hazelcast.jet.datamodel.Tuple2;
import com.hazelcast.jet.datamodel.Tuple4;
import ru.plorum.model.Department;

import java.util.Objects;
import java.util.UUID;

public enum DepartmentRepository {

    INSTANCE;

    public Department createDepartment(final UUID id) {
        final Tuple4<Tuple2<UUID, String>, Tuple2<UUID, String>, Tuple2<UUID, String>, Tuple2<UUID, Integer>> data = HazelcastRepository.INSTANCE.getDeviceZonePatientDepartmentCache().get(id);
        if (Objects.isNull(data)) return null;
        final Tuple2<UUID, String> departmentData = data.f2();
        if (Objects.isNull(departmentData)) return null;
        return new Department(departmentData.f0(), departmentData.f1());
    }

}
