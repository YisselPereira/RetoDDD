package com.sofka.yissel.assistance.values;

import co.com.sofka.domain.generic.Identity;
import com.sofka.yissel.assistance.entities.Doctor;

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
