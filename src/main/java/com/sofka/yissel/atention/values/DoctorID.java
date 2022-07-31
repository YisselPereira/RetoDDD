package com.sofka.yissel.atention.values;

import co.com.sofka.domain.generic.Identity;

public class DoctorID extends Identity {
    public DoctorID(){

    }

    private DoctorID(String id){
        super(id);
    }

    public static DoctorID of(String id){
        return new DoctorID(id);
    }
}
