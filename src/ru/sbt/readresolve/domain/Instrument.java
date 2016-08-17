package ru.sbt.readresolve.domain;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Instrument implements Serializable {
    private final InstrumentType name;
    private final long price;

    Instrument(InstrumentType name, long price) {
        this.name = name;
        this.price = price;
    }

    public InstrumentType getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new Instrument(name, 0);
    }

    private Object readResolve() throws ObjectStreamException {
        return name.get();
    }
}
