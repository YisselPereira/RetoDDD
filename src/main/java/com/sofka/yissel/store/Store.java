package com.sofka.yissel.store;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.yissel.store.entities.Client;
import com.sofka.yissel.store.entities.Merchandise;
import com.sofka.yissel.store.entities.Seller;
import com.sofka.yissel.store.events.*;
import com.sofka.yissel.store.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Store extends AggregateEvent<StoreID> {
    protected Set<Merchandise> merchandises;
    protected Set<Client> clients;
    protected Seller seller;

    public Store(StoreID storeID, Seller seller){
        super(storeID);
        appendChange(new StoreCreated(seller)).apply();
    }

    private Store (StoreID storeID){
        super(storeID);
        subscribe(new StoreChange(this));
    }

    public static Store from(StoreID storeID, List<DomainEvent> events){
        var store = new Store(storeID);
        events.forEach(store::applyEvent);
        return store;
    }

    public void addClient(ClientID clientID, Name name, Phone phone){
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(name);
        Objects.requireNonNull(phone);
        appendChange(new ClientAdded(clientID, name, phone)).apply();
    }

    public void addMerchandise(MerchandiseID merchandiseID, Category category, Price price, Name name){
        Objects.requireNonNull(merchandiseID);
        Objects.requireNonNull(category);
        Objects.requireNonNull(price);
        Objects.requireNonNull(name);
        appendChange(new MerchandiseAdded(merchandiseID, category, price, name)).apply();
    }

    public void removeMerchandise(MerchandiseID merchandiseID){
        Objects.requireNonNull(merchandiseID);
        appendChange(new MerchandiseRemoved(merchandiseID)).apply();
    }

    public void updateClientPhone(ClientID clientID, Phone phone){
        Objects.requireNonNull(clientID);
        Objects.requireNonNull(phone);
        appendChange(new ClientPhoneUpdated(clientID, phone)).apply();
    }

    public void updateMerchandisePrice(MerchandiseID merchandiseID, Price price){
        Objects.requireNonNull(merchandiseID);
        Objects.requireNonNull(price);
        appendChange(new MerchandisePriceUpdated(merchandiseID, price)).apply();
    }

    public void updateSellerPhone(SellerID sellerID, Phone phone){
        Objects.requireNonNull(sellerID);
        Objects.requireNonNull(phone);
        appendChange(new SellerPhoneUpdated(sellerID, phone)).apply();
    }

    public Set<Merchandise> getMerchandises() {
        return merchandises;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public Optional<Client> getClientById(ClientID clientID) {
        return this.clients
                .stream()
                .filter(client -> client.identity().equals(clientID))
                .findFirst();
    }

    public Optional<Object> getMerchandiseById(MerchandiseID merchandiseID) {
        return Optional.of(getMerchandises()
                .stream()
                .filter(merchandise -> merchandise.identity().equals(merchandiseID))
                .findFirst());
    }
}
