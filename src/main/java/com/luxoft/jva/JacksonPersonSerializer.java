package com.luxoft.jva;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class JacksonPersonSerializer extends StdSerializer<Person> {

    @Override
    public void serialize(
        Person person, JsonGenerator jgen, SerializerProvider sp
    ) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("age", person.getAge());
        jgen.writeStringField("name", person.getName());
        jgen.writeEndObject();
    }

    public JacksonPersonSerializer() {
        super(Person.class);
    }
}
