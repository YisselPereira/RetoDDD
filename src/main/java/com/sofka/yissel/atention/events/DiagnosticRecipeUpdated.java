package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.values.DiagnosticID;
import com.sofka.yissel.atention.values.Recipe;

public class DiagnosticRecipeUpdated extends DomainEvent {
    private final DiagnosticID diagnosticID;
    private final Recipe recipe;
    public DiagnosticRecipeUpdated(DiagnosticID diagnosticID, Recipe recipe) {
        super("com.sofka.yissel.atention.diagnosticrecipeupdated");
        this.diagnosticID = diagnosticID;
        this.recipe = recipe;
    }

    public DiagnosticID getDiagnosticID() {
        return diagnosticID;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
