package com.sofka.yissel.atention.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.atention.values.*;

public class AddDiagnostic extends Command {
    private final DoctorID doctorID;
    private final DiagnosticID diagnosticID;
    private final Recipe recipe;
    private final Description description;
    private final Fecha fecha;

    public AddDiagnostic(DoctorID doctorID, DiagnosticID diagnosticID, Recipe recipe, Description description, Fecha fecha) {
        this.doctorID = doctorID;
        this.diagnosticID = diagnosticID;
        this.recipe = recipe;
        this.description = description;
        this.fecha = fecha;
    }

    public DoctorID getDoctorID(){
        return doctorID;
    }

    public DiagnosticID getDiagnosticID() {
        return diagnosticID;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Description getDescription() {
        return description;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
