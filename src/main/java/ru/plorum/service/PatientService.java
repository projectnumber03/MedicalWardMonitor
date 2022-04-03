package ru.plorum.service;

import ru.plorum.model.Patient;
import ru.plorum.repository.PatientRepository;

import java.util.Collections;
import java.util.List;

public enum PatientService {

    INSTANCE;

    public List<Patient> getAll() {
        try {
            return PatientRepository.INSTANCE.getAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
