package com.sofka.yissel.atention.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especiality implements ValueObject<String> {
    private final String value;
    public Especiality(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
