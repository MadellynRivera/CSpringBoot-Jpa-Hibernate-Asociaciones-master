package org.hibernate_jpa_asociaciones.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable /*marca la clase como embebida: significa que es una clase que se utiliza como componente o atributo dentro de otra entidad
            los atributos de esta clase deben ser mapeados directamente a las columnas de la tabla entidad principal con @Embedded, ayuda a mantener
            información de dos clases en una tabla y no tener que hacer dos tablas diferentes*/

//La tabla auditoria genera información acerca de las trasacciones
public class Auditoria {
    @Column(name = "creado_en")
    private LocalDateTime creadoEn;
    @Column(name = "editado_en")
    private LocalDateTime editadoEn;

    @PrePersist
    public void prePersist(){
        System.out.println("Inicializar algo justo antes del persist");
        this.creadoEn = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println("Inicializar algo justo antes del update");
        this.editadoEn =LocalDateTime.now();
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEditadoEn() {
        return editadoEn;
    }

    public void setEditadoEn(LocalDateTime editadoEn) {
        this.editadoEn = editadoEn;
    }
}
