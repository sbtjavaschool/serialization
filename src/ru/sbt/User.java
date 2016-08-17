package ru.sbt;

import java.io.IOException;
import java.io.Serializable;

public class User extends Human implements Serializable {
    private String login;
    private transient Password password;

    public User() {
        this("l", "s");
        System.out.println("111111111111111");
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

    private void writeObject(java.io.ObjectOutputStream out) throws InterruptedException {
        try {
            System.out.println("User.writeObject");
            out.writeUTF(login);
            out.writeUTF(password.getValue());
            out.writeUTF(getRace());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        System.out.println("User.readObject");
        String login = in.readUTF();
        String password = in.readUTF();
        String race = in.readUTF();

        this.login = login;
        this.password = new Password(password);
        this.race = race;
    }
}
