package ru.sbt.readresolve;

import ru.sbt.readresolve.domain.Instrument;
import ru.sbt.readresolve.domain.InstrumentType;
import ru.sbt.utils.SerializationUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static ru.sbt.readresolve.domain.InstrumentType.BOND;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Constructor<Instrument> constructor = Instrument.class.getDeclaredConstructor(InstrumentType.class, long.class);
        constructor.setAccessible(true);
        Instrument instrument = constructor.newInstance(BOND, 1_000_000);

        byte[] bytes = SerializationUtils.serializeToByte(instrument);
        Instrument deserialize = SerializationUtils.deserialize(bytes);
        System.out.println(deserialize.getPrice());
    }
}