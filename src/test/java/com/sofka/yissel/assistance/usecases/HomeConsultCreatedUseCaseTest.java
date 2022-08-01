package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.events.HomeConsultCreated;
import com.sofka.yissel.assistance.events.HomeConsultCreatedMessage;
import com.sofka.yissel.assistance.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HomeConsultCreatedUseCaseTest{
    @InjectMocks
    private HomeConsultCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase() {
        HomeConsultID homeConsultID = HomeConsultID.of("fakeHomeConsultID");
        Price price = new Price(1);
        HomeConsult homeConsult = new HomeConsult(homeConsultID, price);


        var event = new HomeConsultCreated(price);
        event.setAggregateRootId(homeConsultID.value());

        when(repository.getEventsBy("fakeHomeConsultID")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(homeConsultID.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var homecons = (HomeConsultCreatedMessage) events.get(0);

        assertEquals("Consulta a domicilio fue creada", homecons.getMessage());

    }

}
