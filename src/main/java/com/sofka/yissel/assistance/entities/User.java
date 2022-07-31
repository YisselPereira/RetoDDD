package com.sofka.yissel.assistance.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.yissel.assistance.values.*;

import java.util.Objects;

public class User extends Entity<UserID> {

    private Name name;
    private final AnimalType animalType;
    private Address address;

    public User(UserID userID, Name name, AnimalType animalType, Address address) {
        super(userID);
        this.name = name;
        this.animalType = animalType;
        this.address = address;
    }
    public void updateAddress(Address address){
        this.address = Objects.requireNonNull(address);
    }
    public Name name(){
        return name;
    }
    public AnimalType animalType(){
        return animalType;
    }
    public Address address(){
        return address;
    }
}

