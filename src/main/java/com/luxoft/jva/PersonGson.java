package com.luxoft.jva;

import java.util.List;

public class PersonGson {

    private int id;
    private String name;
    private List<String> emails;

    // GSON require no-args constructor for JSON deserialization
    @SuppressWarnings("unused")
    public PersonGson() {
    }

    public PersonGson(int id, String name, List<String> emails) {
        this.id = id;
        this.name = name;
        this.emails = emails;
    }

    public int getId() {
        return id;
    }

    // GSON does not require setters to set fields
    //public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public List<String> getEmails() {
        return emails;
    }
}
