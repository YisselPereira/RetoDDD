package com.sofka.yissel.atention.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.yissel.atention.values.Description;
import com.sofka.yissel.atention.values.DiagnosticID;
import com.sofka.yissel.atention.values.Fecha;
import com.sofka.yissel.atention.values.Recipe;

import java.util.Objects;

public class Diagnostic extends Entity<DiagnosticID> {
    private Recipe recipe;
    private final Description description;
    private final Fecha fecha;

    public Diagnostic(DiagnosticID diagnosticID, Recipe recipe, Description description, Fecha fecha) {
        super(diagnosticID);
        this.recipe = recipe;
        this.description = description;
        this.fecha = fecha;
    }
    public void updateRecipe(Recipe recipe){
        this.recipe = Objects.requireNonNull(recipe);
    }

    public Recipe recipe(){
        return recipe;
    }
    public Description description(){
        return description;
    }
    public Fecha fecha(){
        return fecha;
    }
}
