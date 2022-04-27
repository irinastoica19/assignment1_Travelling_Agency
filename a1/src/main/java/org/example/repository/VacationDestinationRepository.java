package org.example.repository;
import org.example.model.VacationDestination;

import javax.persistence.*;
import java.util.List;

public class VacationDestinationRepository {

    private static final EntityManagerFactory entityManagerfactory =
            Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public static void addVacationDestination(VacationDestination vacationDestination) {
        try {
            EntityManager em = entityManagerfactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(vacationDestination);
            em.getTransaction().commit();
            em.close();
        } catch(PersistenceException e){
            throw new IllegalArgumentException("Invalid ID or destination name");
        }
    }

    public static void deleteVacationDestination(Integer id){
        try {
            EntityManager em = entityManagerfactory.createEntityManager();
            em.getTransaction().begin();
            VacationDestination vacationDestination = em.find(VacationDestination.class, id);
            em.remove(vacationDestination);
            em.getTransaction().commit();
            em.close();
        } catch(PersistenceException e){
            throw new IllegalArgumentException("Invalid ID name");
        }
    }

    public static List<VacationDestination> findAllDestinations(){
        EntityManager em = entityManagerfactory.createEntityManager();
        TypedQuery<VacationDestination> query = em.createQuery("SELECT d FROM VacationDestination d", VacationDestination.class);
        List<VacationDestination> resultList = query.getResultList();
        em.close();
        return resultList;
    }

    public static VacationDestination getReference(Integer id){
        EntityManager em = entityManagerfactory.createEntityManager();
        em.getTransaction().begin();
        VacationDestination vacationDestination = em.getReference(VacationDestination.class, id);
        em.getTransaction().commit();
        em.close();
        return vacationDestination;
    }

}
