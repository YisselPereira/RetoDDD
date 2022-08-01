package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.commands.AddDiagnostic;
import com.sofka.yissel.atention.events.DiagnosticAdded;
import com.sofka.yissel.atention.events.DoctorAdded;
import com.sofka.yissel.atention.values.*;
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
class AddDiagnosticUseCaseTest {

    @InjectMocks
    private AddDiagnosticUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddDiagnosticSuccessfully() {

        DoctorID doctorID = DoctorID.of("fakeDoctorID");
        DiagnosticID diagnosticID = DiagnosticID.of("fakediagnosticID");
        Recipe recipe = new Recipe("Su diagnostico es bueno");
        Description description = new Description("Todo bien");
        Fecha fecha = new Fecha("Hoy es miercoles");

        var command = new AddDiagnostic(doctorID, diagnosticID, recipe, description, fecha);

        when(repository.getEventsBy("fakeDoctorID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getDoctorID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DiagnosticAdded) events.get(0);
        assertEquals("Su diagnostico es bueno", event.getRecipe().value());
        assertEquals("Todo bien", event.getDescription().value());
        assertEquals("Hoy es miercoles", event.getFecha().value());
        Mockito.verify(repository).getEventsBy("fakeDoctorID");
    }

    private List<DomainEvent> history(){
        DoctorID doctorID = DoctorID.of("fakeDoctorID");
        Name name = new Name("Ramon");
        Especiality especiality = new Especiality("Traumatologo");
        var event = new DoctorAdded(name, especiality);
        event.setAggregateRootId(doctorID.value());
        return List.of(event);
    }
}