package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.yissel.atention.Doctor;
import com.sofka.yissel.atention.events.DoctorAdded;
import com.sofka.yissel.atention.values.DoctorID;

public class DoctorAddedUseCase  extends UseCase<TriggeredEvent<DoctorAdded>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<DoctorAdded> doctorAddedTriggeredEvent){
        var event = doctorAddedTriggeredEvent.getDomainEvent();
        var doctor = Doctor.from(DoctorID.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        doctor.doctorAdded("Doctor fue creado");
        emit().onResponse(new ResponseEvents(doctor.getUncommittedChanges()));
    }
}
