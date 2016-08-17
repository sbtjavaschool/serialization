package ru.sbt.basics;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.Serializable;

public class User extends Human implements Serializable {
    private final String login;
    private final Password password;

    public User() {
        this("l", "s");
        System.out.println("constr");
    }

    public User(String login, String password) {
        super("mongolian");
        this.login = login;
        this.password = new Password(password);
        System.out.println("22222222222");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password.getValue();
    }

    @Override
    public String toString() {
        return login + " " + password.getValue() + "," + getRace();
    }

    public Object writeReplace() {
        return new UserDto(login, password.getValue());
    }
}
