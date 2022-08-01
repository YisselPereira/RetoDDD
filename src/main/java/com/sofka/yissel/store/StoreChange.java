package com.sofka.yissel.store;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.yissel.atention.events.DiagnosticRecipeUpdated;
import com.sofka.yissel.store.entities.Client;
import com.sofka.yissel.store.events.ClientAdded;
import com.sofka.yissel.store.events.ClientPhoneUpdated;
import com.sofka.yissel.store.events.StoreCreated;


public class StoreChange extends EventChange {
    public StoreChange(Store store) {
        apply((StoreCreated event) ->{
            store.seller = event.getSeller();
        });

        apply((ClientAdded event) ->{
            store.clients.add(new Client(
                    event.getClientID(),
                    event.getName(),
                    event.getPhone()));
        });

        apply((ClientPhoneUpdated event) ->{
            var clientPhone = store.getClientById(event.getClientID())
                    .orElseThrow(() -> new IllegalArgumentException("Client not phone"));
            clientPhone.updatePhone(event.getPhone());
        });

    }
}

