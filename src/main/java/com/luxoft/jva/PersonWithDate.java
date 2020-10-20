package com.luxoft.jva;

import java.time.LocalDate;

public class PersonWithDate {

    private final String name;
    private final LocalDate birthDay;

    public PersonWithDate(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }
}
