package ru.sbt.readresolve.domain;

public enum InstrumentType {
    EQUITY {
        @Override
        public Instrument get() {
            return new Instrument(this, 100);
        }
    },
    BOND {
        @Override
        public Instrument get() {
            return new Instrument(this, 400);
        }
    };

    public abstract Instrument get();
}
