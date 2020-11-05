package com.luxoft.jva;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(
    namespace = "http://example.com",
    localName = "person"
)
public class PersonJacksonXml {

    @JacksonXmlProperty(
        namespace = "http://example.com",
        localName = "age",
        isAttribute = true
    )
    private int age;
    @JacksonXmlProperty(
        namespace = "http://example.com",
        localName = "name"
    )
    private String name;

    public PersonJacksonXml() {
    }

    public PersonJacksonXml(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
