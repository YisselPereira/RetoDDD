package com.sofka.yissel.assistance.events;

import co.com.sofka.domain.generic.DomainEvent;

public class HomeConsultCreatedMessage extends DomainEvent {
    private final String message;

    public HomeConsultCreatedMessage(String message) {
        super("com.sofka.yissel.assistance.homeconsultcreatedmessage");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
