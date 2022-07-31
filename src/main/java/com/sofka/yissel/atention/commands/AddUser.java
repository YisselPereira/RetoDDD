package com.sofka.yissel.atention.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.atention.values.*;

public class AddUser extends Command {
    private final DoctorID doctorID;
    private final UserID userID;
    private final Name name;
    private final Animal animal;
    private final Race race;

    public AddUser(DoctorID doctorID, UserID userID, Name name, Animal animal, Race race) {
        this.doctorID = doctorID;
        this.userID = userID;
        this.name = name;
        this.animal = animal;
        this.race = race;
    }

    public DoctorID getDoctorID(){
        return doctorID;
    }

    public UserID getUserID() {
        return userID;
    }

    public Name getName() {
        return name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Race getRace() {
        return race;
    }
}
