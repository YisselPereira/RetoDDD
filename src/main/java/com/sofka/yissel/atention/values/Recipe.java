package com.sofka.yissel.atention.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Recipe implements ValueObject<String> {
    private final String value;

    public Recipe(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
