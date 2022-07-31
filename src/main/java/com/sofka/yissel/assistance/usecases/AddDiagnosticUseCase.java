package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.commands.AddDiagnostic;

public class AddDiagnosticUseCase extends UseCase<RequestCommand<AddDiagnostic>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDiagnostic> addDiagnosticRequestCommand){
        var command = addDiagnosticRequestCommand.getCommand();
        HomeConsult homeConsult = HomeConsult.from(command.homeConsultID(), repository().getEventsBy(command.homeConsultID().value()));

       homeConsult.addDiagnostic(command.getDiagnosticID(), command.getRecipe(), command.getDescription(), command.getFecha());

        emit().onResponse(new ResponseEvents(homeConsult.getUncommittedChanges()));
    }
}
