package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dominio.Usuaria;

@ApplicationScoped
public class RepositoryUsuaria implements PanacheRepositoryBase<Usuaria, String> {
}