package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.values.HomeConsultID;
import com.sofka.yissel.assistance.values.Price;

public class HomeConsultCreated extends DomainEvent {
    private final HomeConsultID homeConsultID;
    private Price price;
    public HomeConsultCreated(HomeConsultID homeConsultID, Price price) {
        super("com.sofka.yissel.assistance.homeconsultcreated");
        this.homeConsultID = homeConsultID;
        this.price = price;
    }

    public HomeConsultID getHomeConsultID() {
        return homeConsultID;
    }

    public Price getPrice() {
        return price;
    }
}
