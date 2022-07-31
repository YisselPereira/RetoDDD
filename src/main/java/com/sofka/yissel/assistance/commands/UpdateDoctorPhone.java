package com.sofka.yissel.assistance.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.assistance.values.*;

public class UpdateDoctorPhone extends Command {
    private final HomeConsultID homeConsultID;
    private final DoctorID doctorID;
    private final Phone phone;

    public UpdateDoctorPhone(HomeConsultID homeConsultID, DoctorID doctorID, Phone phone) {
        this.homeConsultID = homeConsultID;
        this.doctorID = doctorID;
        this.phone = phone;
    }

    public HomeConsultID getHomeConsultID() {
        return homeConsultID;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public Phone getPhone() {
        return phone;
    }
}
