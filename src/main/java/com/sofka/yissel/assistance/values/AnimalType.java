package com.sofka.yissel.assistance.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AnimalType implements ValueObject<String> {
    private final String value;

    public AnimalType(String value) throws IllegalAccessException {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalAccessException("AnimalType cant be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }
}