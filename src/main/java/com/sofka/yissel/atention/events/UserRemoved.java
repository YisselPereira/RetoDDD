package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.values.UserID;

public class UserRemoved extends DomainEvent {
    private final UserID userID;
    public UserRemoved(UserID userID) {
        super("com.sofka.yissel.atention.userremoved");
        this.userID = userID;
    }

    public UserID getUserID() {
        return userID;
    }
}
