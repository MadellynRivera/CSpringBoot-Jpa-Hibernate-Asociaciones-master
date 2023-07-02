package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.Direccion;
import org.hibernate_jpa_asociaciones.entity.Factura;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToManyFind {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 2L);
            Direccion d1 = new Direccion("El vergel", 123);
            Direccion d2 = new Direccion("vasco de gama", 456);
            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            em.merge(cliente);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
