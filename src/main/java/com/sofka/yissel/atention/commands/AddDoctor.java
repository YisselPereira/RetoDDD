package com.sofka.yissel.atention.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.atention.values.DoctorID;
import com.sofka.yissel.atention.values.Especiality;
import com.sofka.yissel.atention.values.Name;

public class AddDoctor extends Command {
    private final DoctorID doctorID;
    private final Name name;
    private final Especiality especiality;

    public AddDoctor(DoctorID doctorID, Name name, Especiality especiality) {
        this.doctorID = doctorID;
        this.name = name;
        this.especiality = especiality;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public Name getName() {
        return name;
    }

    public Especiality getEspeciality() {
        return especiality;
    }
}
