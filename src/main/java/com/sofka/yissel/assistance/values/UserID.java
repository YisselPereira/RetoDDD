package com.sofka.yissel.assistance.values;

import co.com.sofka.domain.generic.Identity;

public class UserID extends Identity {
    public UserID(){

    }

    private UserID(String id){
        super(id);
    }

    public static UserID of(String id){
        return new UserID(id);
    }
}
