package com.sofka.yissel.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.values.MerchandiseID;

import java.util.UUID;

public class MerchandiseRemoved extends DomainEvent {
    private final MerchandiseID merchandiseID;

    public MerchandiseRemoved(MerchandiseID merchandiseID) {
        super("com.sofka.yissel.store.merchandiseremoved");
        this.merchandiseID = merchandiseID;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }
}
