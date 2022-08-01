package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.commands.AddUser;
import com.sofka.yissel.atention.events.UserAdded;
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
class AddUserUseCaseTest {

    @InjectMocks
    private AddUserUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AddUserSuccessfully() {

        DoctorID doctorID = DoctorID.of("fakeDoctorID");
        UserID userID = UserID.of("fakeUserID");
        Name name = new Name("chowito");
        Animal animal = new Animal("Perro");
        Race race = new Race("chowchow");

        var command = new AddUser(doctorID, userID, name, animal, race);

        when(repository.getEventsBy("fakeDoctorID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getDoctorID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (UserAdded) events.get(0);
        assertEquals("chowito", event.getName().value());
        assertEquals("Perro", event.getAnimal().value());
        assertEquals("chowchow", event.getRace().value());
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
    