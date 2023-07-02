package org.hibernate_jpa_asociaciones.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//clase que conecta con persistence
public class JpaUtil {
    private  static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
    private static  EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("ejemploJPA");
    }
    public  static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
