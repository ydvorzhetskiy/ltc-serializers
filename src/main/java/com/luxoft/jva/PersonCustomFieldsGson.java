package com.luxoft.jva;

import com.google.gson.annotations.SerializedName;

public class PersonCustomFieldsGson {

    @SerializedName("_id")
    private int id;

    @SerializedName("personName")
    private String name;

    public PersonCustomFieldsGson() {
    }

    public PersonCustomFieldsGson(int id, String name) {
        this.id = id;
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
