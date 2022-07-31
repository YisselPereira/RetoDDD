package com.sofka.yissel.assistance.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.assistance.values.*;


public class UpdateUserAddress extends Command {
    private final HomeConsultID homeConsultID;
    private final UserID userID;
    private final Address address;

    public UpdateUserAddress(HomeConsultID homeConsultID, UserID userID, Address address) {
        this.homeConsultID = homeConsultID;
        this.userID = userID;
        this.address = address;
    }

    public HomeConsultID getHomeConsultID() {
        return homeConsultID;
    }

    public UserID getUserID() {
        return userID;
    }

    public Address getAddress() {
        return address;
    }
}

