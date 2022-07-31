package com.sofka.yissel.assistance;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.yissel.assistance.events.*;
import com.sofka.yissel.assistance.entities.*;

import java.util.HashSet;

public class HomeConsultChange extends EventChange {
    public HomeConsultChange(HomeConsult homeConsult) {
        apply((HomeConsultCreated event) ->{
            homeConsult.price = event.getPrice();
        });

        apply((UserAdded event) ->{
            homeConsult.user = new User(
                    event.getUserID(),
                    event.getName(),
                    event.getAnimalType(),
                    event.getAddress()
            );
        });

        apply((DiagnosticAdded event) ->{
            homeConsult.diagnostic = new Diagnostic(
                    event.getDiagnosticID(),
                    event.getRecipe(),
                    event.getDescription(),
                    event.getFecha()
            );
        });

        apply((DiagnosticRecipeUpdated event) ->{
            homeConsult.diagnostic.updateRecipe(event.getRecipe());
        });

        apply((UserAddressUpdated event) ->{
           homeConsult.user.updateAddress(event.getAddress());
        });

        apply((DoctorAdded event) ->{
            homeConsult.doctor = new Doctor(
                    event.getDoctorID(),
                    event.getName(),
                    event.getEspeciality(),
                    event.getPhone()
            );
        });

        apply((DoctorPhoneUpdated event) ->{
            homeConsult.doctor.updatePhone(event.getPhone());
        });
    }
}
