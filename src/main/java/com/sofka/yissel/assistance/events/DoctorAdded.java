package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.values.DoctorID;
import com.sofka.yissel.assistance.values.Especiality;
import com.sofka.yissel.assistance.values.Name;
import com.sofka.yissel.assistance.values.Phone;

public class DoctorAdded extends DomainEvent {
    private final DoctorID doctorID;
    private final Name name;
    private final Especiality especiality;
    private final Phone phone;
    public DoctorAdded(DoctorID doctorID, Name name, Especiality especiality, Phone phone) {
        super("com.sofka.yissel.assistance.doctoradded");
        this.doctorID = doctorID;
        this.name = name;
        this.especiality = especiality;
        this.phone = phone;
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

    public Phone getPhone() {
        return phone;
    }
}
