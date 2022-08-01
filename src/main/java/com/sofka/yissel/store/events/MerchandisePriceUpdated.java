package com.sofka.yissel.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.values.Category;
import com.sofka.yissel.store.values.MerchandiseID;
import com.sofka.yissel.store.values.Name;
import com.sofka.yissel.store.values.Price;

import java.util.UUID;

public class MerchandisePriceUpdated extends DomainEvent {
    private final MerchandiseID merchandiseID;
    private final Price price;

    public MerchandisePriceUpdated(MerchandiseID merchandiseID, Price price) {
        super("com.sofka.yissel.store.merchandisepriceupdated");
        this.merchandiseID = merchandiseID;
        this.price = price;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Price getPrice() {
        return price;
    }
}
