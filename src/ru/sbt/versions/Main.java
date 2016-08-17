package ru.sbt.versions;

import ru.sbt.utils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;

import static ru.sbt.utils.SerializationUtils.deserialize;
import static ru.sbt.utils.SerializationUtils.serialize;

public class Main implements Serializable {
    private int x = 9999;

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        Person alex = new Person("Alex", 12);
//        serialize(alex);

//        serialize(new Main());
        deserialize();

//        Field field = Main.class.getDeclaredField("serialVersionUID");
//        System.out.println(field.get(null));
    }
}
