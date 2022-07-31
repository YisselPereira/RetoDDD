package com.sofka.yissel.assistance.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.yissel.assistance.values.*;

import java.util.Objects;

public class Doctor extends Entity<DoctorID> {
    private Name name;
    private final Especiality especiality;
    private Phone phone;

    public Doctor(DoctorID doctorID, Name name, Especiality especiality, Phone phone) {
        super(doctorID);
        this.name = name;
        this.especiality = especiality;
        this.phone = phone;
    }

    public void updatePhone(Phone phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    public Name name() {
        return name;
    }

    public Especiality especiality() {
        return especiality;
    }

    public Phone phone() {
        return phone;
    }
}
