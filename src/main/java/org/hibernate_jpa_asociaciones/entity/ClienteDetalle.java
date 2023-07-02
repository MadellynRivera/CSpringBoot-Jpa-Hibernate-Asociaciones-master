package org.hibernate_jpa_asociaciones.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "clientes_detalles")
public class ClienteDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean prime;

    @Column(name="puntos_acumulados")
    private Long puntosAcumulados;

    //Para crear las relaciones
    @OneToOne
    @JoinColumn(name="cliente_detalle_id")
    private Cliente cliente; //aca lo une con el atributo cliente de la clase Cliente

    public ClienteDetalle(boolean prime, Long puntosAcumulados){

        this.prime = prime;
        this.puntosAcumulados = puntosAcumulados;

    }

    public ClienteDetalle() {
    }

    public ClienteDetalle(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public Long getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(Long puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    @Override
    public String toString() {
        return "ClienteDetalle{" +
                "id=" + id +
                ", prime=" + prime +
                ", puntosAcumulados=" + puntosAcumulados +
                ", cliente=" + cliente +
                '}';
    }
}
