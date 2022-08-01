package com.sofka.yissel.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.store.values.*;

public class UpdateSellerPhone extends Command {
    private final StoreID storeID;
    private final SellerID sellerID;
    private final Phone phone;

    public UpdateSellerPhone(StoreID storeID, SellerID sellerID, Phone phone) {
        this.storeID = storeID;
        this.sellerID = sellerID;
        this.phone = phone;
    }

    public StoreID getStoreID() {
        return storeID;
    }

    public SellerID getSellerID() {
        return sellerID;
    }

    public Phone getPhone() {
        return phone;
    }
}

