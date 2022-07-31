package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.yissel.atention.Doctor;
import com.sofka.yissel.atention.commands.AddDiagnostic;

public class AddDiagnosticUseCase extends UseCase<RequestCommand<AddDiagnostic>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDiagnostic> addDiagnosticRequestCommand){
        var command = addDiagnosticRequestCommand.getCommand();
        Doctor doctor = Doctor.from(command.getDoctorID(), repository().getEventsBy(command.getDoctorID().value()));

        doctor.addDiagnostic(command.getDiagnosticID(), command.getRecipe(), command.getDescription(), command.getFecha());

        emit().onResponse(new ResponseEvents(doctor.getUncommittedChanges()));
    }
}
