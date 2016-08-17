package ru.sbt.versions;

import java.io.Serializable;

public class Person implements Serializable {
    public static final long serialVersionUID = 1856394715558540015L;
    private String name;
    private String gender;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void r222() {
    }
}
