package com.github.yuizho;

import java.util.Objects;

public final class Yen {
    int value;

    public Yen(int value) {
        if (value < 0) throw new IllegalArgumentException("value must be greater than 0");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Yen plus(Yen yen) {
        return new Yen(value + yen.value);
    }

    public Yen minus(Yen yen) {
        return new Yen(value - yen.value);
    }

    public boolean isGreaterThan(Yen yen) {
        return value > yen.value;
    }

    public boolean isLessThan(Yen yen) {
        return value < yen.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yen yen = (Yen) o;
        return value == yen.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Yen{" +
                "value=" + value +
                '}';
    }
}
