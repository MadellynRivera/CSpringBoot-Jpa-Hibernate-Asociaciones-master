package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.Factura;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

import java.awt.event.FocusAdapter;

public class HibernateAsociacionesManyToOneFind {

    public static void main(String[] args) {


        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 1L);
            Factura factura = new Factura("compras de oficina", 1000L);
            factura.setCliente(cliente);
            em.persist(factura);
            System.out.println(factura.getCliente());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
