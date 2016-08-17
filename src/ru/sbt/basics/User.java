package ru.sbt.basics;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;

public class User extends Human implements Externalizable {
    private String login;
    private transient Password password;

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

    @Override
    public void writeExternal(java.io.ObjectOutput out) {
        try {
            System.out.println("User.writeObject");
            out.writeUTF(login);
            out.writeUTF(password.getValue());
            out.writeUTF(getRace());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("User.readObject");
        String login = in.readUTF();
        String password = in.readUTF();
        String race = in.readUTF();

        this.login = login;
        this.password = new Password(password);
        this.race = race;
    }
}
