package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        List<Cliente> clientes = em.createQuery("select distinct c from Cliente  c " +
                "left outer join fetch c.direcciones left outer join fetch c.detalle",
                Cliente.class).getResultList();

        clientes.forEach(c -> System.out.println(c.getNombre() + ", direcciones: " + c.getDirecciones()));
        em.close();
    }
}
