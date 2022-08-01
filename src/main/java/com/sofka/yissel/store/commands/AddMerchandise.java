package com.sofka.yissel.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.store.entities.Merchandise;
import com.sofka.yissel.store.values.*;

public class AddMerchandise extends Command {
    private final StoreID storeID;
    private final MerchandiseID merchandiseID;
    private final Category category;
    private final Price price;
    private final Name name;

    public AddMerchandise(StoreID storeID, MerchandiseID merchandiseID, Category category, Price price, Name name) {
        this.storeID = storeID;
        this.merchandiseID = merchandiseID;
        this.category = category;
        this.price = price;
        this.name = name;
    }

    public StoreID getStoreID() {
        return storeID;
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
