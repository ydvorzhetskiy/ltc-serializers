package com.luxoft.jva;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonJackson {
    @JsonProperty(value = "_id", index = 2)
    private final int id;
    @JsonProperty(index = 1)
    private final String name;
    @JsonIgnore
    private final String password;

    public PersonJackson(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @JsonCreator
    public PersonJackson(@JsonProperty("_id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
        this.password = "n/a";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
