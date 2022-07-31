package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.atention.Doctor;
import com.sofka.yissel.atention.commands.UpdateUserName;

public class UpdateUserNameUseCase extends UseCase<RequestCommand<UpdateUserName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateUserName> updateUserNameRequestCommand){
        var command = updateUserNameRequestCommand.getCommand();
        Doctor doctor = Doctor.from(command.getDoctorID(), repository().getEventsBy(command.getDoctorID().value()));
        doctor.updateUserName(command.getUserID(), command.getName());
        emit().onResponse(new ResponseEvents(doctor.getUncommittedChanges()));
    }
}
