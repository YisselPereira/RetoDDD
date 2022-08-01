package com.sofka.yissel.store.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.store.Store;
import com.sofka.yissel.store.commands.AddClient;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand){
        var command = addClientRequestCommand.getCommand();
        Store store = Store.from(command.getStoreID(), repository().getEventsBy(command.getStoreID().value()));

        store.addClient(command.getClientID(), command.getName(), command.getPhone());

        emit().onResponse(new ResponseEvents(store.getUncommittedChanges()));
    }
}
