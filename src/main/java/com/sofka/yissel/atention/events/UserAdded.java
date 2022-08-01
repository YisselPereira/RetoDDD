package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.values.UserID;
import com.sofka.yissel.atention.values.Animal;
import com.sofka.yissel.atention.values.Name;
import com.sofka.yissel.atention.values.Race;

public class UserAdded extends DomainEvent {
    private final UserID userID;
    private final Name name;
    private final Animal animal;
    private final Race race;

    public UserAdded(UserID userID, Name name, Animal animal, Race race) {
        super("com.sofka.yissel.atention.useradded");
        this.userID = userID;
        this.name = name;
        this.animal = animal;
        this.race = race;
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
