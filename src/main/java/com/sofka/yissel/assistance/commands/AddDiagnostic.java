package com.sofka.yissel.assistance.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.values.*;

public class AddDiagnostic extends Command {
    private final HomeConsultID homeConsultID;
    private final DiagnosticID diagnosticID;
    private final Recipe recipe;
    private final Description description;
    private final Fecha fecha;

    public AddDiagnostic(HomeConsultID homeConsultID, DiagnosticID diagnosticID, Recipe recipe, Description description, Fecha fecha) {
        this.homeConsultID = homeConsultID;
        this.diagnosticID = diagnosticID;
        this.recipe = recipe;
        this.description = description;
        this.fecha = fecha;
    }

    public HomeConsultID homeConsultID(){
        return homeConsultID;
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
