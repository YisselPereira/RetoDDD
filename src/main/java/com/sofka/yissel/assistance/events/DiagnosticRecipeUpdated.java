package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.values.DiagnosticID;
import com.sofka.yissel.assistance.values.Recipe;

public class DiagnosticRecipeUpdated extends DomainEvent {
    private final DiagnosticID diagnosticID;
    private final Recipe recipe;
    public DiagnosticRecipeUpdated(DiagnosticID diagnosticID, Recipe recipe) {
        super("com.sofka.yissel.assistance.diagnosticrecipeupdate");
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
