package org.acme;


import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dominio.Item;
import org.acme.dominio.Usuaria;

import java.util.Optional;

@ApplicationScoped
public class ServiceOlli {

    public ServiceOlli() {
    }

    public Usuaria cargaUsuaria (String nombre){
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(nombre);
        return usuaria.isPresent() ? usuaria.get() : new Usuaria();
    }

    public Item cargaItem (String nombre) {
        Optional<Item> item = Item.findByIdOptional(nombre);
        return item.isPresent() ? item.get() : new Item();
    }
}
