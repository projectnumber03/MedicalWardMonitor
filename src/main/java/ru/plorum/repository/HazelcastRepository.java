package ru.plorum.repository;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.jet.datamodel.Tuple2;
import com.hazelcast.jet.datamodel.Tuple4;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

public enum HazelcastRepository {

    INSTANCE;

    @Getter
    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    public Map<UUID, Tuple4<Tuple2<UUID, String>, Tuple2<UUID, String>, Tuple2<UUID, String>, Tuple2<UUID, Integer>>> getDeviceZonePatientDepartmentCache() {
        return hazelcastInstance.getMap("deviceZonePatientDepartmentBedCache");
    }

}
