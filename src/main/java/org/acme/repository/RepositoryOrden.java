package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dominio.Orden;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class RepositoryOrden implements PanacheRepository<Orden> {


    public List<Orden> findUsingUserName(String nombreUser){

        List<Orden> ordenList = this.listAll();
        List<Orden> filteredOrden = new ArrayList<>();

        for(Orden orden : ordenList) {

            if (orden.getUser().getNombre().equalsIgnoreCase(nombreUser)) {
                filteredOrden.add(orden);
            }
        }
        return filteredOrden;
    }

}
