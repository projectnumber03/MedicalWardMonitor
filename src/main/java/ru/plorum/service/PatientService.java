package ru.plorum.service;

import lombok.extern.log4j.Log4j2;
import ru.plorum.model.Patient;
import ru.plorum.repository.PatientRepository;

import java.util.Collections;
import java.util.List;

@Log4j2
public enum PatientService {

    INSTANCE;

    public List<Patient> getAll() {
        try {
            return PatientRepository.INSTANCE.getAll();
        } catch (Exception e) {
            log.info("no patients", e);
            return Collections.emptyList();
        }
    }

}
