package ru.plorum.repository;

import ru.plorum.model.Patient;
import ru.plorum.service.PropertiesService;
import ru.plorum.util.ObjectMapper;
import ru.plorum.util.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public enum PatientRepository {

    INSTANCE;

    public List<Patient> getAll() throws Exception {
        final String zoneName = new String(PropertiesService.INSTANCE.getString("zone.name").getBytes(StandardCharsets.ISO_8859_1));
        final String body = WebClient.INSTANCE.get(String.format("/get-attached-patients-by-zone?name=%s", URLEncoder.encode(zoneName, StandardCharsets.UTF_8)));
        return new ObjectMapper().readValue(body);
    }

}
