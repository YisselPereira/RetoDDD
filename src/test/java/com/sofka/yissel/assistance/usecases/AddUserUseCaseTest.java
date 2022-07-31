package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.commands.AddDoctor;
import com.sofka.yissel.assistance.commands.AddUser;
import com.sofka.yissel.assistance.events.DoctorAdded;
import com.sofka.yissel.assistance.events.HomeConsultCreated;
import com.sofka.yissel.assistance.events.UserAdded;
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
class AddUserUseCaseTest {

    @InjectMocks
    private AddUserUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void AddUserSuccessfully() throws IllegalAccessException {

        HomeConsultID homeConsultID = HomeConsultID.of("fakeHomeConsultID");
        UserID userID = UserID.of("fakeUserID");
        Name name = new Name("Chowie");
        AnimalType animalType = new AnimalType("Perro");
        Address address = new Address("mdeo");

        var command = new AddUser(userID, homeConsultID, name, animalType, address);

        when(repository.getEventsBy("fakeHomeConsultID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getHomeConsultID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (UserAdded) events.get(0);
        assertEquals("fakeUserID", event.getUserID().value());
        assertEquals("Chowie", event.getName().value());
        assertEquals("Perro", event.getAnimalType().value());
        assertEquals("mdeo", event.getAddress().value());
        Mockito.verify(repository).getEventsBy("fakeHomeConsultID");
    }

    private List<DomainEvent> history() {
        HomeConsultID homeConsultID = HomeConsultID.of("fakeHomeConsultID");
        Price price = new Price(1);
        var event = new HomeConsultCreated(price);
        event.setAggregateRootId(homeConsultID.value());
        return List.of(event);
    }
};