package com.sofka.yissel.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.store.values.ClientID;
import com.sofka.yissel.store.values.Phone;
import com.sofka.yissel.store.values.StoreID;

public class UpdateClientPhone extends Command {
    private final StoreID storeID;
    private final ClientID clientID;
    private final Phone phone;

    public UpdateClientPhone(StoreID storeID, ClientID clientID, Phone phone) {
        this.storeID = storeID;
        this.clientID = clientID;
        this.phone = phone;
    }

    public StoreID getStoreID() {
        return storeID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Phone getPhone() {
        return phone;
    }
}
