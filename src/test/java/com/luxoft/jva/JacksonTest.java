package com.luxoft.jva;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Jackson (JSON) examples")
public class JacksonTest {

    @DisplayName("Custom fields serialization")
    @Test
    void customFieldsSerialization() throws Exception {
        // creating ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // object to serialize
        PersonJackson person = new PersonJackson(42, "John", "123456");

        // serialize
        String json = objectMapper.writeValueAsString(person);

        assertEquals("{\"name\":\"John\",\"_id\":42}", json);
    }

    @DisplayName("Deserialization using @JsonCreator")
    @Test
    void customDeserialization() throws Exception {
        // creating ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        String json = "{\"name\":\"John\",\"_id\":42}";

        PersonJackson person = objectMapper.readValue(json, PersonJackson.class);

        assertEquals("n/a", person.getPassword());
    }
}
