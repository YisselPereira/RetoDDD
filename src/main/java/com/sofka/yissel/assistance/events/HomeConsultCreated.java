package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.assistance.values.HomeConsultID;
import com.sofka.yissel.assistance.values.Price;

public class HomeConsultCreated extends DomainEvent {
    private Price price;
    public HomeConsultCreated(Price price) {
        super("com.sofka.yissel.assistance.homeconsultcreated");
        this.price = price;
    }


    public Price getPrice() {
        return price;
    }
}
