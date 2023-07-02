package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();



        Cliente cliente = em.createQuery("select c from Cliente  c left outer join fetch " +
                        "c.direcciones left join fetch  c.detalle where  c.id=:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult(); //para mostrar datos especificos
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        System.out.println(cliente.getNombre() + ", detalle: " + cliente.getDetalle());
        em.close();
    }
}
