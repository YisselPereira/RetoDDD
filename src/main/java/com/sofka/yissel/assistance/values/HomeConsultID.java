package com.sofka.yissel.assistance.values;

import co.com.sofka.domain.generic.Identity;

public class HomeConsultID extends Identity {
    public HomeConsultID(){

    }

    private HomeConsultID(String id){
        super(id);
    }

    public static HomeConsultID of(String id){
        return new HomeConsultID(id);
    }
}
