package org.example.repository;

import org.example.model.VacationPackage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class VacationPackageRepository {

    private static final EntityManagerFactory entityManagerfactory =
            Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public static void addVacationPackage(VacationPackage vacationPackage) {
        EntityManager em = entityManagerfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(vacationPackage);
        em.getTransaction().commit();
        em.close();
    }

    public static VacationPackage getReference(String id){
        EntityManager em = entityManagerfactory.createEntityManager();
        em.getTransaction().begin();
        VacationPackage vacationPackage = em.getReference(VacationPackage.class, id);
        em.getTransaction().commit();
        em.close();
        return vacationPackage;
    }

}
