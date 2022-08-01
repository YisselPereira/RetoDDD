package com.sofka.yissel.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.values.ClientID;
import com.sofka.yissel.store.values.Name;
import com.sofka.yissel.store.values.Phone;

import java.util.UUID;

public class ClientAdded extends DomainEvent {
    private final ClientID clientID;
    private final Name name;
    private final Phone phone;

    public ClientAdded(ClientID clientID, Name name, Phone phone) {
        super("com.sofka.yissel.store.clientadded");
        this.clientID = clientID;
        this.name = name;
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public ClientID getClientID() {
        return clientID;
    }
}

