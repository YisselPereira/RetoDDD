package com.sofka.yissel.assistance.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.assistance.values.*;

public class AddDoctor extends Command {
    private final DoctorID doctorID;
    private final HomeConsultID homeConsultID;
    private final Name name;
    private final Especiality especiality;
    private final Phone phone;

    public AddDoctor(DoctorID doctorID, HomeConsultID homeConsultID, Name name, Especiality especiality, Phone phone) {
        this.doctorID = doctorID;
        this.homeConsultID = homeConsultID;
        this.name = name;
        this.especiality = especiality;
        this.phone = phone;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public HomeConsultID getHomeConsultID() {
        return homeConsultID;
    }

    public Name getName() {
        return name;
    }

    public Especiality getEspeciality() {
        return especiality;
    }

    public Phone getPhone() {
        return phone;
    }
}

