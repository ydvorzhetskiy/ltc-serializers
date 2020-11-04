package com.luxoft.jva;

import com.google.gson.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
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

    @DisplayName("Custom fields names and transient field")
    @Test
    void customFieldNames() {
        Gson gson = new Gson();

        // serialize object to JSON
        String json = gson.toJson(new PersonCustomFieldsGson(
            42, 18, "John Doe", "pass"
        ));

        // {"_id":42,"age":18,"personName":"John Doe"}
        System.out.println(json);

        assertEquals("{\"id\":42,\"_age\":18,\"personName\":\"John Doe\"}", json);
    }

    @DisplayName("Expose and expose strategy field")
    @Test
    void exposeFieldNames() {
        Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

        // serialize object to JSON
        String json = gson.toJson(new PersonExposeGson(
            42, "John Doe", "pass"
        ));

        assertEquals("{\"id\":42,\"name\":\"John Doe\"}", json);
    }

    @DisplayName("Field names and exclusions strategy")
    @Test
    void fieldNamesStrategy() {
        Gson gson = new GsonBuilder()
            .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .addSerializationExclusionStrategy(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getName().equals("id");
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .setPrettyPrinting()
            .create();

        String json = gson.toJson(new PersonGson(42, "Ivan", emptyList()));

        assertEquals("{\n" +
            "  \"name\": \"Ivan\",\n" +
            "  \"emails\": []\n" +
            "}", json);
    }
}
