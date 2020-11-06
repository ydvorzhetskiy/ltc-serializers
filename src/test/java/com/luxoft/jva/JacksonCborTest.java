package com.luxoft.jva;

import com.fasterxml.jackson.dataformat.cbor.databind.CBORMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Jackson CBOR example")
public class JacksonCborTest {

    private final CBORMapper cborMapper = new CBORMapper();

    @DisplayName("Serialization to the CBOR format and deserialization")
    @Test
    void smileSerialization() throws Exception {
        PersonJacksonCbor person = new PersonJacksonCbor(42, "Ivan");

        byte[] binary = cborMapper.writeValueAsBytes(person);

        System.out.println(new String(binary));
        /*
        :)
        �bid*dnamedIvan�
         */

        PersonJacksonSmile deserialized = cborMapper.readValue(binary, PersonJacksonSmile.class);

        assertEquals("Ivan", deserialized.getName());
    }
}
