package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.commands.AddDiagnostic;
import com.sofka.yissel.assistance.events.DiagnosticAdded;
import com.sofka.yissel.assistance.events.HomeConsultCreated;
import com.sofka.yissel.assistance.usecases.AddDiagnosticUseCase;
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
class AddDiagnosticUseCaseTest {

    @InjectMocks
    private AddDiagnosticUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddDiagnosticSuccessfully() throws IllegalAccessException {

        HomeConsultID homeConsultID = HomeConsultID.of("fakeHomeConsultID");
        DiagnosticID diagnosticID = DiagnosticID.of("fakediagnosticID");
        Recipe recipe = new Recipe("Su diagnostico es bueno");
        Description description = new Description("Todo bien");
        Fecha fecha = new Fecha("Hoy es miercoles");

        var command = new AddDiagnostic(homeConsultID, diagnosticID, recipe, description, fecha);

        when(repository.getEventsBy("fakeHomeConsultID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.homeConsultID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DiagnosticAdded) events.get(0);
        assertEquals("Su diagnostico es bueno", event.getRecipe().value());
        assertEquals("Todo bien", event.getDescription().value());
        assertEquals("Hoy es miercoles", event.getFecha().value());
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