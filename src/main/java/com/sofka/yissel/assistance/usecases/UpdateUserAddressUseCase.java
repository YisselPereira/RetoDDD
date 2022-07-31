package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.commands.UpdateUserAddress;

public class UpdateUserAddressUseCase extends UseCase<RequestCommand<UpdateUserAddress>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateUserAddress> updateUserAddressRequestCommand){
        var command = updateUserAddressRequestCommand.getCommand();
        HomeConsult homeConsult = HomeConsult.from(command.getHomeConsultID(), repository().getEventsBy(command.getHomeConsultID().value()));
        homeConsult.updateUserAddress(command.getUserID(), command.getAddress());
        emit().onResponse(new ResponseEvents(homeConsult.getUncommittedChanges()));
    }
}
