package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.atention.Doctor;
import com.sofka.yissel.atention.commands.UpdateDiagnosticRecipe;

public class UpdateDiagnosticRecipeUseCase extends UseCase<RequestCommand<UpdateDiagnosticRecipe>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDiagnosticRecipe> updateDiagnosticRecipeRequestCommand){
        var command = updateDiagnosticRecipeRequestCommand.getCommand();
        Doctor doctor = Doctor.from(command.getDoctorID(), repository().getEventsBy(command.getDoctorID().value()));
        emit().onResponse(new ResponseEvents(doctor.getUncommittedChanges()));
    }
}
