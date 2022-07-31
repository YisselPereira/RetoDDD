package com.sofka.yissel.assistance.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.assistance.values.*;

public class UpdateDiagnosticRecipe extends Command {
    private final HomeConsultID homeConsultID;
    private final DiagnosticID diagnosticID;
    private final Recipe recipe;

    public UpdateDiagnosticRecipe(HomeConsultID homeConsultID, DiagnosticID diagnosticID, Recipe recipe) {
        this.homeConsultID = homeConsultID;
        this.diagnosticID = diagnosticID;
        this.recipe = recipe;
    }

    public HomeConsultID getHomeConsultID() {
        return homeConsultID;
    }

    public DiagnosticID getDiagnosticID() {
        return diagnosticID;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
