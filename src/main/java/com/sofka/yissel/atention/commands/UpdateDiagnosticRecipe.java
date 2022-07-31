package com.sofka.yissel.atention.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.atention.entities.Diagnostic;
import com.sofka.yissel.atention.values.DiagnosticID;
import com.sofka.yissel.atention.values.DoctorID;
import com.sofka.yissel.atention.values.Recipe;

public class UpdateDiagnosticRecipe extends Command {
    private final DoctorID doctorID;
    private final DiagnosticID diagnosticID;
    private final Recipe recipe;

    public UpdateDiagnosticRecipe(DoctorID doctorID, DiagnosticID diagnosticID, Recipe recipe) {
        this.doctorID = doctorID;
        this.diagnosticID = diagnosticID;
        this.recipe = recipe;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public DiagnosticID getDiagnosticID() {
        return diagnosticID;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
