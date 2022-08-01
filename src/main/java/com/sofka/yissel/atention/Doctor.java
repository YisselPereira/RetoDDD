package com.sofka.yissel.atention;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.entities.User;
import com.sofka.yissel.atention.entities.Diagnostic;
import com.sofka.yissel.atention.events.*;
import com.sofka.yissel.atention.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Doctor extends AggregateEvent<DoctorID> {
    protected Name name;
    protected Especiality especiality;
    protected Set<User> users;
    protected Set<Diagnostic> diagnostics;

    public Doctor(DoctorID doctorID, Name name, Especiality especiality) {
        super(doctorID);
       appendChange(new DoctorAdded(name, especiality)).apply();
    }

    private Doctor(DoctorID doctorID){
        super(doctorID);
        subscribe(new DoctorChange(this));
    }

    public static Doctor from(DoctorID doctorID, List<DomainEvent> events){
        var doctor = new Doctor(doctorID);
        events.forEach(doctor::applyEvent);
        return doctor;
    }

    /*public void addDoctor(DoctorID doctorID, Name name, Especiality especiality){
        Objects.requireNonNull(doctorID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(especiality);
        appendChange(new DoctorAdded(name, especiality)).apply();
    }*/

    public void addUser(UserID userID, Name name, Animal animal, Race race){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(animal);
        Objects.requireNonNull(race);
        appendChange(new UserAdded(userID, name, animal, race)).apply();
    }

    public void addDiagnostic(DiagnosticID diagnosticID, Recipe recipe, Description description, Fecha fecha){
        Objects.requireNonNull(diagnosticID);
        Objects.requireNonNull(recipe);
        Objects.requireNonNull(description);
        Objects.requireNonNull(fecha);
        appendChange(new DiagnosticAdded(diagnosticID, recipe, description, fecha)).apply();
    }

    public void removeUser(UserID userID){
        appendChange(new UserRemoved(userID)).apply();
    }

    public void removeDiagnostic(DiagnosticID diagnosticID){
        appendChange(new DiagnosticRemoved(diagnosticID)).apply();
    }

    public void updateUserName(UserID userID, Name name){
        Objects.requireNonNull(userID);
        Objects.requireNonNull(name);
        appendChange(new UserNameUpdated(userID, name)).apply();
    }

    public void updateDiagnosticRecipe(DiagnosticID diagnosticID, Recipe recipe){
        Objects.requireNonNull(diagnosticID);
        Objects.requireNonNull(recipe);
        appendChange(new DiagnosticRecipeUpdated(diagnosticID, recipe)).apply();
    }

    /*public void createHomeConsult(){

    }*/

    public Optional<Diagnostic> getDiagnosticById(DiagnosticID diagnosticID){
        return getDiagnostics()
                .stream()
                .filter(diagnostic -> diagnostic.identity().equals(diagnosticID))
                .findFirst();
    }

    public Optional<User> getUserById(UserID userID){
        return getUsers()
                .stream()
                .filter(user -> user.identity().equals(userID))
                .findFirst();
    }

    public Name getName() {
        return name;
    }

    public Especiality getEspeciality() {
        return especiality;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Diagnostic> getDiagnostics() {
        return diagnostics;
    }

    public void doctorAdded(String message) {
        appendChange(new DoctorAddedMessage(message)).apply();
    }
}
