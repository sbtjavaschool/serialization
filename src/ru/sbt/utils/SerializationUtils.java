package ru.sbt.utils;

import java.io.*;

public class SerializationUtils {
    private static final String FILE = "f.ser";

    public static void serialize(Serializable o) throws IOException {
        serialize(o, FILE);
    }

    public static byte[] serializeToByte(Serializable o) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream stream = new ObjectOutputStream(
                bytes)) {
            stream.writeObject(o);
        }
        return bytes.toByteArray();
    }

    public static <T> T deserialize() throws IOException, ClassNotFoundException {
        return deserialize(FILE);
    }

    public static void serialize(Serializable o, String file) throws IOException {
        try (ObjectOutputStream stream = new ObjectOutputStream(
                new FileOutputStream(file))) {
            stream.writeObject(o);
        }
    }

    public static <T> T deserialize(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream(file))) {
            return (T) stream.readObject();
        }
    }

    public static <T> T deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ObjectInputStream stream = new ObjectInputStream(
                new ByteArrayInputStream(bytes))) {
            return (T) stream.readObject();
        }
    }
}
