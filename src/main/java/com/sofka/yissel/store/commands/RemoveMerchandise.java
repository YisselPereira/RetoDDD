package com.sofka.yissel.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.store.values.*;

public class RemoveMerchandise extends Command {
    private final StoreID storeID;
    private final MerchandiseID merchandiseID;

    public RemoveMerchandise(StoreID storeID, MerchandiseID merchandiseID) {
        this.storeID = storeID;
        this.merchandiseID = merchandiseID;
    }

    public StoreID getStoreID() {
        return storeID;
    }

    public MerchandiseID getMerchandiseID() {
        return merchandiseID;
    }
}