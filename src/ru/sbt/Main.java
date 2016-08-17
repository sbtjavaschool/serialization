package ru.sbt;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialize();
        System.out.println("___________________");
        User user = deserialize();
        System.out.println(user);
    }

    private static User deserialize() throws IOException, ClassNotFoundException {
        try(ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream("user.ser"))) {
            Object o = stream.readObject();
            return (User) o;
        }
    }

    private static void serialize() throws IOException {
        User user = new User("Alex", "secret");

        try(ObjectOutputStream stream =
                    new ObjectOutputStream(
                            new FileOutputStream("user.ser"))) {
            stream.writeObject(user);
        }
    }
}
