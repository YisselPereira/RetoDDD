package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.atention.commands.UpdateUserName;
import com.sofka.yissel.atention.events.DoctorAdded;
import com.sofka.yissel.atention.events.UserAdded;
import com.sofka.yissel.atention.events.UserNameUpdated;
import com.sofka.yissel.atention.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UpdateUserNameUseCaseTest {
    @InjectMocks
    private UpdateUserNameUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateUserNameSuccessfully() {

        DoctorID doctorID = DoctorID.of("doctorID");
        UserID userID = UserID.of("userID");
        Name name = new Name("Edduardo");

        var command = new UpdateUserName(doctorID, userID, name);

        List<DomainEvent> domainEvents1 = List.of(
                new DoctorAdded(new Name("Ramon"), new Especiality("traumatologo")),
                new UserAdded(UserID.of("userID"), new Name("michi"), new Animal("dog"), new Race("dogo")),
                new UserAdded(UserID.of("userID123456"), new Name("chochi"), new Animal("perrito"), new Race("golden"))
        );
        Mockito.when(repository.getEventsBy("doctorID")).thenReturn(domainEvents1);

        useCase.addRepository(repository);

        var domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor(doctorID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (UserNameUpdated) domainEvents.get(0);
        assertEquals("Edduardo", event.getName().value());
        assertEquals("userID", event.getUserID().value());
        Mockito.verify(repository).getEventsBy("doctorID");
    }
}