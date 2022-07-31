package com.sofka.yissel.atention.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Animal implements ValueObject<String> {
    private final String value;

    public Animal(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
