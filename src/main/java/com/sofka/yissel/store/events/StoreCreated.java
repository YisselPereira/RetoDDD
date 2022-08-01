package com.sofka.yissel.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.entities.Seller;

public class StoreCreated extends DomainEvent {
    private final Seller seller;
    public StoreCreated(Seller seller) {
        super("com.sofka.yissel.store.storecreated");
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }
}
