package com.sofka.yissel.assistance.values;

import co.com.sofka.domain.generic.Identity;


public class DiagnosticID extends Identity {
    public DiagnosticID(){

    }
    private DiagnosticID(String id){
        super(id);
    }
    public static DiagnosticID of(String id){
        return new DiagnosticID(id);
    }
}
