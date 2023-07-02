package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.ClienteDetalle;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToOneBidireccionalFind {
    public static void main(String[] args) {
        EntityManager em = new JpaUtil().getEntityManager();


        try{
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 2L);
            ClienteDetalle detalle = new ClienteDetalle(true,8000L);
            cliente.addDetalle(detalle);
            em.getTransaction().commit();
            System.out.println(cliente);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
