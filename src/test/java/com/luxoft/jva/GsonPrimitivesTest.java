package com.luxoft.jva;

import com.google.gson.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("GSON primitives")
public class GsonPrimitivesTest {

    @DisplayName("Serialization and deserialization")
    @Test
    void simpleSerialization() {
        Gson gson = new Gson();

        String json = gson.toJson(1);

        assertEquals("1", json);
    }
}
