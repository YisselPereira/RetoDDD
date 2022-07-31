package com.sofka.yissel.atention.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.atention.values.DoctorID;
import com.sofka.yissel.atention.values.Name;
import com.sofka.yissel.atention.values.UserID;

public class UpdateUserName extends Command {
    private final DoctorID doctorID;
    private final UserID userID;
    private final Name name;

    public UpdateUserName(DoctorID doctorID, UserID userID, Name name) {
        this.doctorID = doctorID;
        this.userID = userID;
        this.name = name;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public UserID getUserID() {
        return userID;
    }

    public Name getName() {
        return name;
    }
}
