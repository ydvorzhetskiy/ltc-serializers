package com.luxoft.jva;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Jackson XML example")
public class JacksonXmlTest {


    private final XmlMapper xmlMapper = new XmlMapper();

    @DisplayName("Serialize to XML")
    @Test
    void smileSerialization() throws Exception {
        PersonJacksonXml person = new PersonJacksonXml(42, "Vlad");

        String result = xmlMapper.writeValueAsString(person);

        System.out.println(result);
    }
}
