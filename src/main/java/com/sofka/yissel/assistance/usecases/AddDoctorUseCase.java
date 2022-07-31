package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.commands.AddDoctor;

public class AddDoctorUseCase extends UseCase<RequestCommand<AddDoctor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddDoctor> addDoctorRequestCommand) {
        var command = addDoctorRequestCommand.getCommand();
        var homeConsult = HomeConsult.from(command.getHomeConsultID(), repository().getEventsBy(command.getHomeConsultID().value()));
        homeConsult.addDoctor(command.getDoctorID(), command.getName(), command.getEspeciality(), command.getPhone());
        emit().onResponse(new ResponseEvents(homeConsult.getUncommittedChanges()));
    }
}
