package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.values.Especiality;
import com.sofka.yissel.atention.values.Name;

public class DoctorAdded extends DomainEvent {
    private Name name;
    private Especiality especiality;

    public DoctorAdded(Name name, Especiality especiality) {
        super("com.sofka.yissel.atention.doctoradded");
        this.name = name;
        this.especiality = especiality;
    }

    public Name getName() {
        return name;
    }

    public Especiality getEspeciality() {
        return especiality;
    }
}
