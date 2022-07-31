package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.atention.Doctor;
import com.sofka.yissel.atention.commands.AddDoctor;

public class AddDoctorUseCase extends UseCase<RequestCommand<AddDoctor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddDoctor> addDoctorRequestCommand) {
        var command = addDoctorRequestCommand.getCommand();
        var doctor = new Doctor(command.getDoctorID(), command.getName(), command.getEspeciality());

        emit().onResponse(new ResponseEvents(doctor.getUncommittedChanges()));
    }
}
