package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.commands.AddUser;

public class AddUserUseCase extends UseCase<RequestCommand<AddUser>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddUser> addUserRequestCommand){
        var command = addUserRequestCommand.getCommand();
        HomeConsult homeConsult = HomeConsult.from(command.getHomeConsultID(), repository().getEventsBy(command.getHomeConsultID().value()));

        homeConsult.addUser(command.getUserID(), command.getName(), command.getAnimalType(), command.getAddress());

        emit().onResponse(new ResponseEvents(homeConsult.getUncommittedChanges()));
    }
}

