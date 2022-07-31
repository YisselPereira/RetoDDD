package com.sofka.yissel.assistance.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especiality implements ValueObject<String> {
    private final String value;

    public Especiality(String value) throws IllegalAccessException {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalAccessException("Especiality cant be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }
}