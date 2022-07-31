package com.sofka.yissel.assistance.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.assistance.values.*;

public class AddUser extends Command {
    private final UserID userID;
    private final HomeConsultID homeConsultID;
    private final Name name;
    private final AnimalType animalType;
    private final Address address;

    public AddUser(UserID userID, HomeConsultID homeConsultID, Name name, AnimalType animalType, Address address) {
        this.userID = userID;
        this.homeConsultID = homeConsultID;
        this.name = name;
        this.animalType = animalType;
        this.address = address;
    }

    public UserID getUserID() {
        return userID;
    }

    public HomeConsultID getHomeConsultID() {
        return homeConsultID;
    }

    public Name getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public Address getAddress() {
        return address;
    }
}
