package com.luxoft.jva;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nustaq.serialization.FSTConfiguration;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("FST examples")
public class FstTest {

    private final FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();

    @DisplayName("Serialization and deserialization")
    @Test
    void serializationAndDeserialization() {
        PersonFst person = new PersonFst(42, "Ivan");

        byte[] result = conf.asByteArray(person);

        System.out.println(new String(result));

        PersonFst read = (PersonFst) conf.asObject(result);

        assertEquals(person, read);
    }
}
