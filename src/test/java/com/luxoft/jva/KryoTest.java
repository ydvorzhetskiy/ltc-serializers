package com.luxoft.jva;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Kryo example")
public class KryoTest {

    private Kryo kryo;

    @BeforeEach
    void setUp() {
        kryo = new Kryo();
        kryo.register(PersonKryo.class);
    }

    @DisplayName("Simple serialization and deserialization")
    @Test
    void serialization() {
        kryo = new Kryo();
        kryo.register(PersonKryo.class);

        PersonKryo person = new PersonKryo(18, "Ivan");

        ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
        Output output = new Output(bos);
        kryo.writeObject(output, person);
        output.close();

        System.out.println(new String(bos.toByteArray()));
        // $Iva�

        Input input = new Input(bos.toByteArray());
        PersonKryo read = kryo.readObject(input, PersonKryo.class);
        input.close();

        assertEquals(person, read);
    }
}
