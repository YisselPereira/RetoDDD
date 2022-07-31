package com.sofka.yissel.atention.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.yissel.atention.values.DiagnosticID;
import com.sofka.yissel.atention.values.DoctorID;

public class RemoveDiagnostic extends Command {
    private final DoctorID doctorID;
    private final DiagnosticID diagnosticID;

    public RemoveDiagnostic(DoctorID doctorID, DiagnosticID diagnosticID) {
        this.doctorID = doctorID;
        this.diagnosticID = diagnosticID;
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public DiagnosticID getDiagnosticID() {
        return diagnosticID;
    }
}
