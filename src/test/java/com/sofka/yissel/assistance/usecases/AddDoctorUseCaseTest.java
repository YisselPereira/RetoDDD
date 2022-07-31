package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.commands.AddDiagnostic;
import com.sofka.yissel.assistance.commands.AddDoctor;
import com.sofka.yissel.assistance.events.DiagnosticAdded;
import com.sofka.yissel.assistance.events.DoctorAdded;
import com.sofka.yissel.assistance.events.HomeConsultCreated;
import com.sofka.yissel.assistance.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddDoctorUseCaseTest {

    @InjectMocks
    private AddDoctorUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddDoctorSuccessfully() throws IllegalAccessException {

        HomeConsultID homeConsultID = HomeConsultID.of("fakeHomeConsultID");
        DoctorID doctorID = DoctorID.of("fakeDoctorID");
        Name name = new Name("Ramon");
        Especiality especiality = new Especiality("Fisioterapeuta");
        Phone phone = new Phone("091");

        var command = new AddDoctor(doctorID, homeConsultID, name, especiality, phone);

        when(repository.getEventsBy("fakeHomeConsultID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getHomeConsultID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DoctorAdded) events.get(0);
        assertEquals("fakeDoctorID", event.getDoctorID().value());
        assertEquals("Ramon", event.getName().value());
        assertEquals("Fisioterapeuta", event.getEspeciality().value());
        assertEquals("091", event.getPhone().value());
        Mockito.verify(repository).getEventsBy("fakeHomeConsultID");
    }

    private List<DomainEvent> history(){
        HomeConsultID homeConsultID = HomeConsultID.of("fakeHomeConsultID");
        Price price = new Price(1);
        var event = new HomeConsultCreated(price);
        event.setAggregateRootId(homeConsultID.value());
        return List.of(event);
    }
}