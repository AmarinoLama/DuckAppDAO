package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dominio.Item;

@ApplicationScoped
public class RepositoryItem implements PanacheRepositoryBase<Item, String> {
}