package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.atention.Doctor;
import com.sofka.yissel.atention.commands.AddUser;

public class AddUserUseCase extends UseCase<RequestCommand<AddUser>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddUser> addUserRequestCommand){
        var command = addUserRequestCommand.getCommand();
        Doctor doctor = Doctor.from(command.getDoctorID(), repository().getEventsBy(command.getDoctorID().value()));

        doctor.addUser(command.getUserID(), command.getName(), command.getAnimal(), command.getRace());

        emit().onResponse(new ResponseEvents(doctor.getUncommittedChanges()));
    }
}
