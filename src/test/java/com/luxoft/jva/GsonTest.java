package com.luxoft.jva;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("GSON examples")
public class GsonTest {

    @DisplayName("Simple JSON serialization")
    @Test
    void simpleSerialization() {
        // creating GSON object using default configuration;
        Gson gson = new Gson();

        // serialize object to JSON
        String json = gson.toJson(
            new PersonGson(
                42, "John Doe", singletonList("jd@ex.com")
            )
        );
        // {"id":42,"name":"John Doe","emails":["jd@ex.com"]}

        assertEquals("{\"id\":42,\"name\":\"John Doe\",\"emails\":[\"jd@ex.com\"]}", json);
    }

    @DisplayName("Simple JSON deserialization")
    @Test
    void simpleDeserialization() {
        Gson gson = new Gson();

        // deserialize
        PersonGson obj = gson.fromJson(
            "{\"id\":42,\"name\":\"John Doe\",\"emails\":[\"jd@ex.com\"]}",
            PersonGson.class
        );

        assertEquals("John Doe", obj.getName());
    }

    @DisplayName("Custom fields names")
    @Test
    void customFieldNames() {
        Gson gson = new Gson();

        // serialize object to JSON
        String json = gson.toJson(new PersonCustomFieldsGson(42, "John Doe"));

        assertEquals("{\"_id\":42,\"personName\":\"John Doe\"}", json);
    }
}
