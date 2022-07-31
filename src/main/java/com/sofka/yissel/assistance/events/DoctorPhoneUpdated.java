package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.values.DoctorID;
import com.sofka.yissel.assistance.values.Phone;

public class DoctorPhoneUpdated extends DomainEvent {
    private final DoctorID doctorId;
    private final Phone phone;

    public DoctorPhoneUpdated(DoctorID doctorID, Phone phone) {
        super("com.sofka.yissel.assistance.doctorphoneupdated");
        this.doctorId = doctorID;
        this.phone = phone;
    }

    public DoctorID getDoctorId() {
        return doctorId;
    }

    public Phone getPhone() {
        return phone;
    }
}
