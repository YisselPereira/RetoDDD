package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.events.HomeConsultCreated;
import com.sofka.yissel.assistance.values.HomeConsultID;
import com.sofka.yissel.assistance.commands.UpdateDiagnosticRecipe;
import com.sofka.yissel.assistance.events.DiagnosticAdded;
import com.sofka.yissel.assistance.events.DiagnosticRecipeUpdated;
import com.sofka.yissel.assistance.events.DoctorAdded;
import com.sofka.yissel.assistance.usecases.UpdateDiagnosticRecipeUseCase;
import com.sofka.yissel.assistance.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateDiagnosticRecipeUseCaseTest {
    @InjectMocks
    private UpdateDiagnosticRecipeUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateDiagnosticRecipeSuccessfully() throws IllegalAccessException {

        HomeConsultID homeConsultID = HomeConsultID.of("homeConsultID");
        DiagnosticID diagnosticID = DiagnosticID.of("diagnosticID");
        Recipe recipe = new Recipe("Receta actualizada");

        var command = new UpdateDiagnosticRecipe(homeConsultID, diagnosticID, recipe);

        List<DomainEvent> domainEvents1 = List.of(
                new HomeConsultCreated(new Price(1)),
                new DiagnosticAdded(DiagnosticID.of("diagnosticID"), new Recipe("hola"), new Description("todo bien"), new Fecha("lunes")),
                new DiagnosticAdded(DiagnosticID.of("diagnosticID123456"), new Recipe("65"), new Description("todo buenisimo"), new Fecha("martes"))
        );
        Mockito.when(repository.getEventsBy("homeConsultID")).thenReturn(domainEvents1);

        useCase.addRepository(repository);

        var domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor(homeConsultID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DiagnosticRecipeUpdated) domainEvents.get(0);
        assertEquals("Receta actualizada", event.getRecipe().value());
        assertEquals("diagnosticID", event.getDiagnosticID().value());
        Mockito.verify(repository).getEventsBy("homeConsultID");
    }
}