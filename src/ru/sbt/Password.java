package ru.sbt;

import java.io.Serializable;

public class Password implements Serializable {
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
