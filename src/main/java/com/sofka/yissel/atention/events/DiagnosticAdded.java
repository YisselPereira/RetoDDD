package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.values.Description;
import com.sofka.yissel.atention.values.DiagnosticID;
import com.sofka.yissel.atention.values.Fecha;
import com.sofka.yissel.atention.values.Recipe;

public class DiagnosticAdded extends DomainEvent {
    private final DiagnosticID diagnosticID;
    private final Recipe recipe;
    private final Description description;
    private final Fecha fecha;
    public DiagnosticAdded(DiagnosticID diagnosticID, Recipe recipe, Description description, Fecha fecha) {
        super("com.sofka.yissel.atention.diagnosticadded");
        this.diagnosticID = diagnosticID;
        this.recipe = recipe;
        this.description = description;
        this.fecha = fecha;
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
