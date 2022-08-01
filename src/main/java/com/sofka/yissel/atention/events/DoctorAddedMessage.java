package com.sofka.yissel.atention.events;

import co.com.sofka.domain.generic.DomainEvent;

public class DoctorAddedMessage extends DomainEvent {
    private final String message;

    public DoctorAddedMessage(String message) {
        super("com.sofka.yissel.atention.doctoraddedmessage");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
