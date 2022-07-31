package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.commands.UpdateUserAddress;
import com.sofka.yissel.assistance.events.*;
import com.sofka.yissel.assistance.values.HomeConsultID;
import com.sofka.yissel.assistance.commands.UpdateDiagnosticRecipe;
import com.sofka.yissel.assistance.usecases.UpdateUserAddressUseCase;
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
class UpdateUserAddressUseCaseTest {
    @InjectMocks
    private UpdateUserAddressUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateUserAddressSuccessfully() throws IllegalAccessException {

        HomeConsultID homeConsultID = HomeConsultID.of("homeConsultID");
        UserID userID = UserID.of("userID");
        Address address = new Address("Nueva direccion");

        var command = new UpdateUserAddress(homeConsultID, userID, address);

        List<DomainEvent> domainEvents1 = List.of(
                new HomeConsultCreated(new Price(1)),
                new UserAdded(UserID.of("userID"), new Name("chowie"), new AnimalType("Caniche"), new Address("Paysandu")),
                new UserAdded(UserID.of("otroUserID"), new Name("Michi"), new AnimalType("Gato"), new Address("Montevideo"))
        );
        Mockito.when(repository.getEventsBy("homeConsultID")).thenReturn(domainEvents1);

        useCase.addRepository(repository);

        var domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor(homeConsultID.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (UserAddressUpdated) domainEvents.get(0);
        assertEquals("Nueva direccion", event.getAddress().value());
        assertEquals("userID", event.getUserID().value());
        Mockito.verify(repository).getEventsBy("homeConsultID");
    }
}