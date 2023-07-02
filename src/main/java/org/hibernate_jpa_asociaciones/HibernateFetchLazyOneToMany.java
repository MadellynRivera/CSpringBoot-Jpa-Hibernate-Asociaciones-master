package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

//Una persona puede tener varias direcciones
public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        //Que ubique el cliente con id 1
        //consulta para encontrar cuantas direcciones tiene un cliente
        Cliente cliente = em.find(Cliente.class, 1L);
        System.out.println(cliente.getNombre() + ", " + "direcciones: " + cliente.getDirecciones());
        em.close();
    }
}
