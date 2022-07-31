package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.values.DiagnosticID;

public class DiagnosticRemoved extends DomainEvent {
    private final DiagnosticID diagnosticID;
    public DiagnosticRemoved(DiagnosticID diagnosticID) {
        super("com.sofka.yissel.atention.diagnosticremoved");
        this.diagnosticID = diagnosticID;
    }

    public DiagnosticID getDiagnosticID() {
        return diagnosticID;
    }
}
