package com.luxoft.jva;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Jackson module example")
public class JacksonExtensionsTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .configure(WRITE_DATES_AS_TIMESTAMPS, false)
                .build();
    }

    @DisplayName("Serialize Java 8 LocalDate")
    @Test
    void serializeWithDateTime() throws Exception {
        PersonWithDate personWithDate = new PersonWithDate("Vlad", LocalDate.of(1988, 10, 3));
        String json = objectMapper.writeValueAsString(personWithDate);
        assertEquals("{\"name\":\"Vlad\",\"birthDay\":\"1988-10-03\"}", json);
    }
}
