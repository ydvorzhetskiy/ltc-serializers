package com.luxoft.jva;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Jackson custom serialization")
public class JacksonCustomSerializerTest {

    @DisplayName("Custom serialization")
    @Test
    void customSerialization() throws Exception {
        // create ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // set serializer
        SimpleModule module = new SimpleModule();
        module.addSerializer(Person.class, new JacksonPersonSerializer());
        objectMapper.registerModule(module);

        Person person = new Person(42, "John");

        // serialize
        String json = objectMapper.writeValueAsString(person);
        // {"age":42,"name":"John"}

        assertEquals("{\"age\":42,\"name\":\"John\"}", json);
    }
}
