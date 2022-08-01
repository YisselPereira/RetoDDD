package com.sofka.yissel.store.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.yissel.store.values.*;

public class Seller extends Entity<SellerID> {
    private final Name name;
    private final Phone phone;

    public Seller(SellerID sellerID, Name name, Phone phone) {
        super(sellerID);
        this.name = name;
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }
}
