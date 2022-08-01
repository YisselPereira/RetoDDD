package com.sofka.yissel.store.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.yissel.store.values.ClientID;
import com.sofka.yissel.store.values.Name;
import com.sofka.yissel.store.values.Phone;

import java.util.Objects;

public class Client extends Entity<ClientID> {
    private Name name;
    private Phone phone;

    public Client(ClientID clientID, Name name, Phone phone) {
        super(clientID);
        this.name = name;
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void updatePhone(Phone phone){
        this.phone = phone;
    }
}