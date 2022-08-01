package com.sofka.yissel.atention.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.yissel.atention.Doctor;
import com.sofka.yissel.atention.events.DoctorAdded;
import com.sofka.yissel.atention.events.DoctorAddedMessage;
import com.sofka.yissel.atention.values.DoctorID;
import com.sofka.yissel.atention.values.Especiality;
import com.sofka.yissel.atention.values.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoctorAddedUseCaseTest{
    @InjectMocks
    private DoctorAddedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

   @Test
   void executeUseCase() {
       DoctorID doctorID = DoctorID.of("fakeDoctorID");
       Name name = new Name("lili");
       Especiality especiality = new Especiality("Cardiologa");
       Doctor doctor = new Doctor(doctorID, name, especiality);


       var event = new DoctorAdded(name, especiality);
       event.setAggregateRootId(doctorID.value());

       when(repository.getEventsBy("fakeDoctorID")).thenReturn(List.of(event));
       useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(doctorID.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var ed = (DoctorAddedMessage) events.get(0);

        assertEquals("Doctor fue creado", ed.getMessage());

    }

}

