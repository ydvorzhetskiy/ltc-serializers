package com.luxoft.jva;

import com.google.gson.annotations.SerializedName;

public class PersonCustomFieldsGson {

    @SerializedName("_id")
    private int id;

    private int age;

    @SerializedName("personName")
    private String name;

    public PersonCustomFieldsGson() {
    }

    public PersonCustomFieldsGson(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
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
}
