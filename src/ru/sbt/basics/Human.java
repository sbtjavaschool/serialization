package ru.sbt.basics;

import java.io.Serializable;

public class Human {
    String race;

    protected Human() {
        System.out.println("Human2");
        this.race = "race";
    }

    public Human(String race) {
        System.out.println("Human");
        this.race = race;
    }

    public String getRace() {
        return race;
    }
}
