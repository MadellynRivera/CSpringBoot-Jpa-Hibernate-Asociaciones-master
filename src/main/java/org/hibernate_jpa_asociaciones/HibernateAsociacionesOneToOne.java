package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.ClienteDetalle;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToOne {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();


        try{
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("Paypal");
            em.persist(cliente);
            ClienteDetalle detalle = new ClienteDetalle(true,5000L);
            em.persist(detalle);
            cliente.setDetalle (detalle);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
