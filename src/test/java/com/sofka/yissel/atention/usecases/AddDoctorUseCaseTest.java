package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.commands.AddDoctor;
import com.sofka.yissel.atention.events.DoctorAdded;
import com.sofka.yissel.atention.values.DoctorID;
import com.sofka.yissel.atention.values.Especiality;
import com.sofka.yissel.atention.values.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddDoctorUseCaseTest {
    private AddDoctorUseCase useCase;

    @BeforeEach
    public void setUp(){
        useCase = new AddDoctorUseCase();
    }
    @Test
    public void addDoctorSuccessfully(){

        DoctorID doctorID = DoctorID.of("fakeDoctorID");
        Name name = new Name("Ramon");
        Especiality especiality = new Especiality("Traumatologo");
        AddDoctor command = new AddDoctor(doctorID, name, especiality);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        DoctorAdded doctorAdded = (DoctorAdded) domainEvents.get(0);
        assertEquals("fakeDoctorID", doctorAdded.aggregateRootId());
        assertEquals("Ramon", doctorAdded.getName().value());
        assertEquals("Traumatologo", doctorAdded.getEspeciality().value());
    }

}