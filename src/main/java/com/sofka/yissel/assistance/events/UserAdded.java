package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.values.Address;
import com.sofka.yissel.assistance.values.AnimalType;
import com.sofka.yissel.assistance.values.Name;
import com.sofka.yissel.assistance.values.UserID;
import com.sofka.yissel.atention.entities.User;

public class UserAdded extends DomainEvent {
    private final UserID userID;
    private final Name name;
    private final AnimalType animalType;
    private final Address address;
    public UserAdded(UserID userID, Name name, AnimalType animalType, Address address) {
        super("com.sofka.yissel.assistance.useradded");
        this.userID = userID;
        this.name = name;
        this.animalType = animalType;
        this.address = address;
    }

    public UserID getUserID() {
        return userID;
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
