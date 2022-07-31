package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.commands.UpdateDiagnosticRecipe;

public class UpdateDiagnosticRecipeUseCase extends UseCase<RequestCommand<UpdateDiagnosticRecipe>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDiagnosticRecipe> updateDiagnosticRecipeRequestCommand){
        var command = updateDiagnosticRecipeRequestCommand.getCommand();
        HomeConsult homeConsult = HomeConsult.from(command.getHomeConsultID(), repository().getEventsBy(command.getHomeConsultID().value()));
        homeConsult.updateDiagnosticRecipe(command.getDiagnosticID(), command.getRecipe());
        emit().onResponse(new ResponseEvents(homeConsult.getUncommittedChanges()));
    }
}

