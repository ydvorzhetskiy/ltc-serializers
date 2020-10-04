package com.luxoft.jva;

import java.util.List;

public class PersonGson {

    private int id;
    private String name;
    private List<String> emails;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
