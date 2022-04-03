package ru.plorum.service;

import ru.plorum.repository.PropertiesRepository;

public enum PropertiesService {

    INSTANCE;

    private final PropertiesRepository propertiesRepository = PropertiesRepository.INSTANCE;

    public Integer getInt(final String key) {
        return propertiesRepository.getInt(key);
    }

    public String getString(final String key) {
        return propertiesRepository.getString(key);
    }

}
