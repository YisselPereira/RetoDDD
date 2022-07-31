package com.sofka.yissel.assistance.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.yissel.assistance.HomeConsult;
import com.sofka.yissel.assistance.events.HomeConsultCreated;
import com.sofka.yissel.assistance.values.HomeConsultID;

public class HomeConsultCreatedUseCase extends UseCase<TriggeredEvent<HomeConsultCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<HomeConsultCreated> homeConsultCreatedTriggeredEvent){
        var event = homeConsultCreatedTriggeredEvent.getDomainEvent();
        var homeConsult = HomeConsult.from(HomeConsultID.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
        homeConsult.homeConsultCreated("Consulta a domicilio fue creada");
        emit().onResponse(new ResponseEvents(homeConsult.getUncommittedChanges()));
    }
}

