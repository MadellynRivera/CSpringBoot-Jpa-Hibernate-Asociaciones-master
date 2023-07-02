package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.Factura;
import org.hibernate_jpa_asociaciones.util.JpaUtil;
//package util metodos para gestionar la base de datos

public class HibernateAsociacionesManyToOne {
    public static void main(String[] args) {
        //entity manager maneja las conexiones
        //entity trasaction  maneja las transacciones a la base
        EntityManager manager= JpaUtil.getEntityManager();
        try {
            //manager es el entityManager que hace todas las transsacciones a la base
            //haga esto, cree esto, persista
            manager.getTransaction().begin(); //inicia la transacción
            //envio de información a la clase Cliente
            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("credito");

            manager.persist(cliente);//persist manda la información temporalmente a la ram
            Factura factura = new Factura("compras de oficina",1000L);
            factura.setCliente(cliente);
            manager.persist(factura);
            System.out.println(factura.getCliente());
            System.out.println(factura);
            manager.getTransaction().commit(); //commit confirma la información que esta en la ram

        }catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            manager.close();
        }
    }
}
