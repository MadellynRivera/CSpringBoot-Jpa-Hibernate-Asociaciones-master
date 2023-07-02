package org.hibernate_jpa_asociaciones.entity;

import jakarta.persistence.*;

import java.awt.font.TextHitInfo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity  //para marcar la clase como entidad o que se extraeran los datos de una BD
@Table(name = "clientes") //para especificar la tabla
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name = "forma_pago")
    private String formaPago;

    @Embedded
    private Auditoria auditoria= new Auditoria();



    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)  //crea la relación
    //@JoinColumn(name = "id_cliente")

    //Se crea la tabla tbl_clientes_direcciones que será la union entre clientes y direcciones
    @JoinTable(name = "tbl_clientes_direcciones", joinColumns = @JoinColumn(name = "id_cliente"),
    inverseJoinColumns = @JoinColumn(name = "id_direccion")
            //Seria la constraint a unir y aplica una restricción en la columna id_dirección que no se pueden tener duplicados de direcciones aplicadas a un cliente
    ,uniqueConstraints = @UniqueConstraint(columnNames = {"id_direccion"}))
    private List<Direccion> direcciones;

    //relación de facturas con clientes
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
    private List<Factura> facturas;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
    private ClienteDetalle detalle;

    public Cliente() {
       facturas = new ArrayList<>();
       direcciones = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(Long id, String nombre, String apellido, String formaPago) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }


    public ClienteDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(ClienteDetalle detalle) {
        this.detalle = detalle;
    }

    public void addDetalle(ClienteDetalle detalle){
        this.detalle = detalle;
        detalle.setCliente(this);
    }

    public void removeDetalle(){
        detalle.setCliente(null);
        this.detalle = null;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Cliente addFactura(Factura factura){
        this.facturas.add(factura);
        factura.setCliente(this);
        return this;
    }
    public Cliente removeFactura(Factura factura){
        this.facturas.remove(factura);
        factura.setCliente(null);
        return null;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago + '\'' +
                ", auditoria=" + auditoria +
                ", direcciones=" + direcciones +
                ", facturas=" + facturas +
                ", detalle=" + detalle +
                '}';
    }
}
