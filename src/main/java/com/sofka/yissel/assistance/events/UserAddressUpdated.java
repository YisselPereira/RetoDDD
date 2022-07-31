package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.values.Address;
import com.sofka.yissel.assistance.values.UserID;

public class UserAddressUpdated extends DomainEvent {
    private final UserID userID;
    private Address address;
    public UserAddressUpdated(UserID userID, Address address) {
        super("com.sofka.yissel.assistance.useraddressupdated");
        this.userID = userID;
        this.address = address;
    }

    public UserID getUserID() {
        return userID;
    }

    public Address getAddress() {
        return address;
    }
}
