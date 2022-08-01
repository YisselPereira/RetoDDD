package com.sofka.yissel.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.values.*;

import java.util.UUID;

public class SellerPhoneUpdated extends DomainEvent {
    private final SellerID sellerID;
    private final Phone phone;

    public SellerPhoneUpdated(SellerID sellerID, Phone phone) {
        super("com.sofka.yissel.store.sellerphoneupdated");
        this.sellerID = sellerID;
        this.phone = phone;
    }

    public SellerID getSellerID() {
        return sellerID;
    }

    public Phone getPhone() {
        return phone;
    }
}
