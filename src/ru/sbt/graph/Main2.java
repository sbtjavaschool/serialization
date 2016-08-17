package ru.sbt.graph;

import ru.sbt.basics.User;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*Node n1 = new Node();
        Node n2 = new Node();
        n1.node = n2;
        n2.node = n1;

        serialize(n1);*/
        System.out.println("___________________");
        Node n1 = deserialize();
        System.out.println(n1 == n1.node.node);
    }

    private static<T> T deserialize() throws IOException, ClassNotFoundException {
        try(ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream("f.ser"))) {
            Object o = stream.readObject();
            return (T) o;
        }
    }

    private static void serialize(Object o) throws IOException {
        try(ObjectOutputStream stream =
                    new ObjectOutputStream(
                            new FileOutputStream("f.ser"))) {
            stream.writeObject(o);
        }
    }
}
