package com.sofka.yissel.store.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.values.*;

import java.util.UUID;

public class MerchandiseAdded extends DomainEvent {
    private final MerchandiseID merchandiseID;
    private final Category category;
    private final Price price;
    private  final Name name;

    public MerchandiseAdded(MerchandiseID merchandiseID, Category category, Price price, Name name) {
        super("com.sofka.yissel.store.merchandiseadded");
        this.merchandiseID = merchandiseID;
        this.category = category;
        this.price = price;
        this.name = name;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Category getCategory() {
        return category;
    }

    public Price getPrice() {
        return price;
    }

    public Name getName() {
        return name;
    }
}
