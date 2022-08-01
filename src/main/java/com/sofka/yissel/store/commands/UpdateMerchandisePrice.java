package com.sofka.yissel.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.store.values.MerchandiseID;
import com.sofka.yissel.store.values.Price;
import com.sofka.yissel.store.values.StoreID;


public class UpdateMerchandisePrice extends Command {
    private final StoreID storeID;
    private final MerchandiseID merchandiseID;
    private final Price price;

    public UpdateMerchandisePrice(StoreID storeID, MerchandiseID merchandiseID, Price price) {
        this.storeID = storeID;
        this.merchandiseID = merchandiseID;
        this.price = price;
    }

    public StoreID getStoreID() {
        return storeID;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }

    public Price getPrice() {
        return price;
    }
}
