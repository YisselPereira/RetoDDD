package com.sofka.yissel.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.values.ClientID;
import com.sofka.yissel.store.values.Phone;

import java.util.UUID;

public class ClientPhoneUpdated extends DomainEvent {
    private final ClientID clientID;
    private final Phone phone;

    public ClientPhoneUpdated(ClientID clientID, Phone phone) {
        super("com.sofka.yissel.store.clientphoneupdated");
        this.clientID = clientID;
        this.phone = phone;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Phone getPhone() {
        return phone;
    }
}
