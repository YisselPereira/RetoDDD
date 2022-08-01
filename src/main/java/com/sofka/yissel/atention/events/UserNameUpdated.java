package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.values.Name;
import com.sofka.yissel.atention.values.UserID;

public class UserNameUpdated extends DomainEvent {
    private final UserID userID;
    private final Name name;
    public UserNameUpdated(UserID userID, Name name) {
        super("com.sofka.yissel.atention.usernameupdated");
        this.userID = userID;
        this.name = name;
    }

    public UserID getUserID() {
        return userID;
    }

    public Name getName() {
        return name;
    }
}
