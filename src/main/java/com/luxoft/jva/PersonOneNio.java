package com.luxoft.jva;

import java.io.Serializable;
import java.util.Objects;

public class PersonOneNio implements Serializable {

    private int id;
    private String name;

    public PersonOneNio() {
    }

    public PersonOneNio(int id, String name) {
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

    @Override
    public String toString() {
        return "PersonKryo{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonOneNio that = (PersonOneNio) o;
        return id == that.id &&
            name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
