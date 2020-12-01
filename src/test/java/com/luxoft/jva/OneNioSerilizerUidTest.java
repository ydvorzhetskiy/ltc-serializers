package com.luxoft.jva;

import one.nio.serial.DataStream;
import one.nio.serial.Repository;
import one.nio.serial.Serializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("OneNIO serializer uid check")
public class OneNioSerilizerUidTest {

    @DisplayName("Serialization and deserialization with UID check")
    @Test
    void serializationDeserialization() throws Exception {
        PersonOneNio person = new PersonOneNio(42, "Ivan");

        DataStream outputDataStream = new DataStream(1000);

        {
            // Get OneNIO serializer for PersonOneNio class in writers JVM
            Serializer<PersonOneNio> serializer = Repository.get(PersonOneNio.class);
            // Write serializer's class MD5 hash
            outputDataStream.writeLong(serializer.uid());
            serializer.write(person, outputDataStream);
        }

        byte[] writtenBytes = outputDataStream.array();

        {
            // Get OneNIO serializer for PersonOneNio class in readers JVM
            Serializer<PersonOneNio> serializer = Repository.get(PersonOneNio.class);
            DataStream inputDataStream = new DataStream(writtenBytes);
            // Read persisted serializer's UID
            long uidFromStream = inputDataStream.readLong();
            long uidFromClass = serializer.uid();
            // If not equal - class has been changed and data my be corrupted on reading
            assertEquals(uidFromStream, uidFromClass);
            PersonOneNio read = serializer.read(inputDataStream);
            assertEquals(person, read);
        }
    }
}
