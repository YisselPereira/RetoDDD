package com.sofka.yissel.atention.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.atention.values.DoctorID;
import com.sofka.yissel.atention.values.UserID;

public class RemoveUser extends Command {
    private final DoctorID doctorID;
    private final UserID userID;

    public RemoveUser(DoctorID doctorID, UserID userID) {
        this.doctorID = doctorID;
        this.userID = userID;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public UserID getUserID() {
        return userID;
    }
}
