package com.sofka.yissel.atention;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.yissel.atention.entities.User;
import com.sofka.yissel.atention.entities.Diagnostic;
import com.sofka.yissel.atention.events.*;

import java.util.HashSet;

public class DoctorChange extends EventChange {
    public DoctorChange(Doctor doctor) {
        apply((DoctorAdded event) ->{
            doctor.name = event.getName();
            doctor.especiality = event.getEspeciality();
            doctor.users = new HashSet<>();
            doctor.diagnostics = new HashSet<>();
        });

        apply((UserAdded event) ->{
            doctor.users.add(new User(
                event.getUserID(),
                event.getName(),
                event.getAnimal(),
                event.getRace()
            ));
        });

        apply((DiagnosticAdded event) ->{
            doctor.diagnostics.add(new Diagnostic(
                    event.getDiagnosticID(),
                    event.getRecipe(),
                    event.getDescription(),
                    event.getFecha()
            ));
        });

        apply((DiagnosticRecipeUpdated event) ->{
            var diagnostic = doctor.getDiagnosticById(event.getDiagnosticID())
                    .orElseThrow(() -> new IllegalArgumentException("Diagnostic not found"));
            diagnostic.updateRecipe(event.getRecipe());
        });

        apply((DiagnosticRemoved event) ->{
            var diagnostic = doctor.getDiagnosticById(event.getDiagnosticID())
                    .orElseThrow(() -> new IllegalArgumentException("Diagnostic not found"));
            doctor.diagnostics.remove(diagnostic);
        });

        apply((UserNameUpdated event) ->{
            var user = doctor.getUserById(event.getUserID())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            user.updateName(event.getName());
        });

        apply((UserRemoved event) ->{
            var user = doctor.getUserById(event.getUserID())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            doctor.users.remove(user);
        });
    }
}
