package com.sofka.yissel.assistance;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.entities.Diagnostic;
import com.sofka.yissel.assistance.entities.Doctor;
import com.sofka.yissel.assistance.entities.User;
import com.sofka.yissel.assistance.events.*;
import com.sofka.yissel.assistance.values.*;


import java.util.List;
import java.util.Objects;

public class HomeConsult extends AggregateEvent<HomeConsultID> {
    protected User user;
    protected Doctor doctor;
    protected Diagnostic diagnostic;

    protected Price price;

    public HomeConsult(HomeConsultID homeConsultID, Price price){
        super(homeConsultID);
        appendChange(new HomeConsultCreated(price)).apply();
    }

    private HomeConsult(HomeConsultID homeConsultID){
        super(homeConsultID);
        subscribe(new HomeConsultChange(this));
    }

    public static HomeConsult from(HomeConsultID homeConsultID, List<DomainEvent> events){
        var homeConsult = new HomeConsult(homeConsultID);
        events.forEach(homeConsult::applyEvent);
        return homeConsult;
    }

    public void addUser(UserID userID, Name name, AnimalType animalType, Address address){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(animalType);
        Objects.requireNonNull(address);
        appendChange(new UserAdded(userID, name, animalType, address)).apply();
    }

    public void addDoctor(DoctorID doctorID, Name name, Especiality especiality, Phone phone){
        Objects.requireNonNull(doctorID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(especiality);
        Objects.requireNonNull(phone);
        appendChange(new DoctorAdded( doctorID, name, especiality, phone)).apply();
    }

    public void addDiagnostic(DiagnosticID diagnosticID, Recipe recipe, Description description, Fecha fecha){
        Objects.requireNonNull(diagnosticID);
        Objects.requireNonNull(recipe);
        Objects.requireNonNull(description);
        Objects.requireNonNull(fecha);
        appendChange(new DiagnosticAdded(diagnosticID, recipe, description, fecha)).apply();
    }

    public void updateUserAddress(UserID userID, Address address){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(address);
        appendChange(new UserAddressUpdated(userID, address)).apply();
    }

    public void updateDoctorPhone(DoctorID doctorID,Phone phone){
        Objects.requireNonNull(doctorID);
        Objects.requireNonNull(phone);
        appendChange(new DoctorPhoneUpdated(doctorID,phone)).apply();
    }

    public void updateDiagnosticRecipe(DiagnosticID diagnosticID, Recipe recipe){
        Objects.requireNonNull(diagnosticID);
        Objects.requireNonNull(recipe);
        appendChange(new DiagnosticRecipeUpdated(diagnosticID, recipe)).apply();
    }

    public User getUser() {
        return user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void homeConsultCreated(String message) {
        appendChange(new HomeConsultCreated(price)).apply();
    }
}
