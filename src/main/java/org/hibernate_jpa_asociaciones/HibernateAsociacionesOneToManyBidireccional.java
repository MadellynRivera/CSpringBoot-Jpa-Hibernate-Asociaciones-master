package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Cliente;
import org.hibernate_jpa_asociaciones.entity.Factura;
import org.hibernate_jpa_asociaciones.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccional {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();


        try{
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Cata","Edu");
            cliente.setFormaPago("Paypal");
            //ingresa facturas sin id, para facturas no poner id autoincrementables
            Factura f1 = new Factura("compras de Supermercado", 5000L);
            Factura f2 = new Factura("compras de tecnologia", 7000L);

            cliente.addFactura(f1)
                    .addFactura(f2);

            //procesando la transacción
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);

            em.getTransaction().begin();
            Factura f3 = new Factura("Compras de supermercado",5000L);
            f3.setId(1L);
            //cliente.removeFactura(f3);
            cliente.addFactura(f3);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
