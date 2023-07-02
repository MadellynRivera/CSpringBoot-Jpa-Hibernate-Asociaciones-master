package org.hibernate_jpa_asociaciones.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String descripcion;
    private Long total;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Factura() {
    }

    public Factura(String descripcion, Long total) {
        this.descripcion = descripcion;
        this.total = total;
    }

    public Factura(Long id, String descripcion, Long total, Cliente cliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.total = total;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura " +
                "id: " + id +
                ", descripcion: " + descripcion +
                ", total: " + total +
                ", cliente: " + cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(id, factura.id) && Objects.equals(descripcion, factura.descripcion) && Objects.equals(total, factura.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, total);
    }
}
