package com.sofka.yissel.store.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.yissel.store.values.*;

public class Merchandise extends Entity<MerchandiseID> {
    private Category category;
    private final Price price;
    private final Name name;

    public Merchandise(MerchandiseID entityId, Category category, Price price, Name name) {
        super(entityId);
        this.category = category;
        this.price = price;
        this.name = name;
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