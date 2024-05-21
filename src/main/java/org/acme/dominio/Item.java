package org.acme.dominio;

import jakarta.inject.Inject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.acme.repository.RepositoryItem;

@Entity
@Table(name="t_items")
public class Item {

    @Id
    @Column (name = "item_nom")
    private String nombre = "";

    @Column (name = "item_prop")
    private Integer quality = 0;

    @Column (name = "item_tipo")
    private String tipo = "";

    public Item(String nombre, Integer quality, String tipo) {
        this.nombre = nombre;
        this.quality = quality;
        this.tipo = tipo;
    }

    public Item () {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
