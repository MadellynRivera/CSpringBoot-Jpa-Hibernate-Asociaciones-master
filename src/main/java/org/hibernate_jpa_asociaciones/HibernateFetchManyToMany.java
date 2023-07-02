package org.hibernate_jpa_asociaciones;

import jakarta.persistence.EntityManager;
import org.hibernate_jpa_asociaciones.entity.Alumno;
import org.hibernate_jpa_asociaciones.util.JpaUtil;


import java.util.List;
//relacionado muchos a muchos, por que son muchos alumnos en muchos cursos
public class HibernateFetchManyToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        //distinct : para que distinga un valor
        List<Alumno> alumnos = em.createQuery("select distinct a from Alumno a left " +
                "outer join fetch a.cursos", Alumno.class).getResultList();
        alumnos.forEach(a -> System.out.println(a.getNombre() + ", Cursos: " + a.getCursos()));
        em.close();

    }
}
