package org.acme.dominio;

import io.quarkus.Generated;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table (name = "t_ordenes")
public class Orden extends PanacheEntityBase {

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

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
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
