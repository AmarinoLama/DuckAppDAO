package org.acme.dominio;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import org.acme.repository.RepositoryOrden;

@Entity
@Table (name = "t_ordenes")
public class Orden  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ord_id")
    private Long idOrden = 0l;

    @OneToOne
    @JoinColumn(name="ord_user")
    private Usuaria user = new Usuaria();

    @OneToOne
    @JoinColumn(name="ord_item")
    private Item item = new Item();

    public Orden() {
    }

    public Orden(Usuaria user, Item item) {
        this.user = user;
        this.item = item;
    }

    public Long getId() {
        return idOrden;
    }

    public void setId(Long idOrden) {
        this.idOrden = idOrden;
    }

    public Usuaria getUser() {
        return user;
    }

    public void setUser(Usuaria user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
