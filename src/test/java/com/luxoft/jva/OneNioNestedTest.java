package com.luxoft.jva;

import one.nio.serial.DataStream;
import one.nio.serial.Repository;
import one.nio.serial.Serializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("OneNIO Nested")
public class OneNioNestedTest {

    @DisplayName("Serialization and deserialization")
    @Test
    void serializationDeserialization() throws Exception {
        // all fields must be serializable
        PersonOneNioWithFriend friend = new PersonOneNioWithFriend(18, "Masha", null);
        PersonOneNioWithFriend person = new PersonOneNioWithFriend(18, "Ivan", friend);

        DataStream dataStream = new DataStream(1000);

        // One NIO Serializer
        Serializer<PersonOneNioWithFriend> serializer = Repository.get(PersonOneNioWithFriend.class);
        serializer.write(person, dataStream);

        System.out.println(new String(dataStream.array()));
        /*
         *
         * � Ivan"��Q�6   � Masha�
         */

        // One NIO Deserialization
        DataStream inputDataStream = new DataStream(dataStream.array());

        PersonOneNioWithFriend read = serializer.read(inputDataStream);
        assertEquals(person, read);
    }
}
