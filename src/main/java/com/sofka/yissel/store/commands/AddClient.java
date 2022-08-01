package com.sofka.yissel.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.store.commands.*;
import com.sofka.yissel.store.values.ClientID;
import com.sofka.yissel.store.values.Name;
import com.sofka.yissel.store.values.Phone;
import com.sofka.yissel.store.values.StoreID;

public class AddClient extends Command {
    private final StoreID storeID;
    private final ClientID clientID;
    private final Name name;
    private final Phone phone;

    public AddClient(StoreID storeID, ClientID clientID, Name name, Phone phone) {
        this.storeID = storeID;
        this.clientID = clientID;
        this.name = name;
        this.phone = phone;
    }

    public StoreID getStoreID() {
        return storeID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }
}

