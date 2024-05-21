package org.acme;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dominio.Item;
import org.acme.dominio.Orden;
import org.acme.dominio.Usuaria;
import org.acme.repository.RepositoryItem;
import org.acme.repository.RepositoryOrden;
import org.acme.repository.RepositoryUsuaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServiceOlli {

    @Inject
    RepositoryUsuaria repositoryUsuaria;

    @Inject
    RepositoryOrden repositoryOrden;

    @Inject
    RepositoryItem repositoryItem;

    public ServiceOlli() {
    }

    public Usuaria cargaUsuaria (String nombre){
        Optional<Usuaria> usuaria = repositoryUsuaria.findByIdOptional(nombre);
        return usuaria.isPresent() ? usuaria.get() : new Usuaria();
    }

    public Item cargaItem (String nombre) {
        Optional<Item> item = repositoryItem.findByIdOptional(nombre);
        return item.isPresent() ? item.get() : new Item();
    }

    public List<Orden> cargaOrden(String nombre){

        List<Orden> ordenes = repositoryOrden.listAll();
        List<Orden> ordenesFiltradas = new ArrayList<>();

        for (Orden orden : ordenes) {
            if (orden.getUser().getNombre().equalsIgnoreCase(nombre)) {
                ordenesFiltradas.add(orden);
            }
        }
        return ordenesFiltradas;
    }

    public Orden comanda (String nombreUsuaria, String nombreItem) {

        Orden comanda = null;

        Optional<Usuaria> usuario = repositoryUsuaria.findByIdOptional(nombreUsuaria);
        Optional<Item> item = repositoryItem.findByIdOptional(nombreItem);

        if (usuario.isPresent() && item.isPresent() && usuario.get().getDestreza() >= item.get().getQuality()) {

            comanda = new Orden(usuario.get(),item.get());
            repositoryOrden.persist(comanda);
            }
        return comanda;
    }

    public List<Orden> comandaMultiple (String nombreUsuaria, List<String> nombresItems) {

        List<Orden> listaOrdenes = new ArrayList<>();
        Optional<Usuaria> usuario = repositoryUsuaria.findByIdOptional(nombreUsuaria);
        List<Item> listaItemsExistentes = new ArrayList<>();

        for(String nombre : nombresItems){

            Optional<Item> item = repositoryItem.findByIdOptional(nombre);

            if (item.isPresent()) {
                listaItemsExistentes.add(item.get());
            }

        }

        if (usuario.isPresent() && listaItemsExistentes.size() > 0 ) {

            for (Item item: listaItemsExistentes) {

                Orden comanda = null;
                comanda = new Orden(usuario.get(),item);

                repositoryOrden.persist(comanda);

                listaOrdenes.add(comanda);

            }

        }
        return listaOrdenes;
    }

}
