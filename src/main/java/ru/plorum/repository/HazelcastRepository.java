package ru.plorum.repository;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.Getter;

public enum HazelcastRepository {

    INSTANCE;

    @Getter
    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

}
