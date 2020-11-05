package com.luxoft.jva;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Protobuf examples")
public class ProtobufTest {

    @DisplayName("Serialization and deserialization")
    @Test
    void serializationAndDeserialization() throws IOException {
        PersonProtobuf.Person person = PersonProtobuf.Person.newBuilder()
            .setId(18)
            .setName("Ivan")
            .build();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        person.writeTo(baos);

        System.out.println(new String(baos.toByteArray()));

        PersonProtobuf.Person read = PersonProtobuf.Person.parseFrom(baos.toByteArray());

        assertEquals(person, read);
    }
}
