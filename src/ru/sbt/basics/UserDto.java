package ru.sbt.basics;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class UserDto implements Serializable {
    private String login;
    private String password;

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private void writeObject(java.io.ObjectOutputStream out)   throws IOException {
        out.writeUTF(login);
        out.writeUTF(password);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("User.readObject");
        this.login = in.readUTF();
        this.password = in.readUTF();
    }

    private Object readResolve() throws ObjectStreamException {
        return new User(login, password);
    }
}
