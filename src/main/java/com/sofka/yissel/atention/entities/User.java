package com.sofka.yissel.atention.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.yissel.atention.values.Animal;
import com.sofka.yissel.atention.values.Name;
import com.sofka.yissel.atention.values.Race;
import com.sofka.yissel.atention.values.UserID;

import java.util.Objects;

public class User extends Entity<UserID> {

    private Name name;
    private final Animal animal;
    private final Race race;

    public User(UserID userID, Name name, Animal animal, Race race) {
        super(userID);
        this.name = name;
        this.animal = animal;
        this.race = race;
    }
    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }
    public Name name(){
        return name;
    }
    public Animal animal(){
        return animal;
    }
    public Race race(){
        return race;
    }
}
