package com.sofka.yissel.assistance.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Fecha implements ValueObject<String> {
    private final String value;

    public Fecha(String value) throws IllegalAccessException {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalAccessException("Fecha cant be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }
}