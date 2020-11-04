package com.luxoft.jva;

import com.google.gson.annotations.SerializedName;

public class PersonCustomFieldsGson {

    private int id;

    @SerializedName("_age")
    private int age;

    @SerializedName(
        value = "personName",
        alternate = "firstName"
    )
    private String name;

    private transient String password;

    public PersonCustomFieldsGson() {
    }

    public PersonCustomFieldsGson(int id, int age, String name, String password) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
