package ru.plorum.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {

    public <T> T readValue(final String body) throws JsonProcessingException {
        return readValue(body, new TypeReference<>() {});
    }

    @Override
    public <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JsonProcessingException {
        super.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        super.registerModule(new JavaTimeModule());
        return super.readValue(content, new TypeReference<>() {});
    }

}
