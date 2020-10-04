package com.luxoft.jva;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Collections.singletonList;

public class GsonTest {

    @DisplayName("Simple JSON serialization using GSON")
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
        System.out.println(json);
        // {"id":42,"name":"John Doe","emails":["jd@ex.com"]}
    }
}
