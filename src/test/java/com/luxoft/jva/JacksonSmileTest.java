package com.luxoft.jva;

import com.fasterxml.jackson.dataformat.smile.databind.SmileMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Jackson Smile example")
public class JacksonSmileTest {


    private final SmileMapper smileMapper = new SmileMapper();

    @DisplayName("Serialization to the Smile format and deserialization")
    @Test
    void smileSerialization() throws Exception {
        PersonJacksonSmile person = new PersonJacksonSmile(42, "Vlad");

        byte[] binary = smileMapper.writeValueAsBytes(person);

        System.out.println(new String(binary));

        PersonJacksonSmile deserialized = smileMapper.readValue(binary, PersonJacksonSmile.class);

        assertEquals("Vlad", deserialized.getName());
    }
}
