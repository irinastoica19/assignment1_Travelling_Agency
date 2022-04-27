package org.example.repository;

import org.example.model.VacationDestination;
import org.example.model.VacationPackage;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

    public static VacationPackage getReference(Integer id){
        EntityManager em = entityManagerfactory.createEntityManager();
        em.getTransaction().begin();
        VacationPackage vacationPackage = em.getReference(VacationPackage.class, id);
        em.getTransaction().commit();
        em.close();
        return vacationPackage;
    }

    public static List<VacationPackage> findPackagesByDestination(Integer destinationId){
        EntityManager em = entityManagerfactory.createEntityManager();
        TypedQuery<VacationPackage> query = em.createQuery("SELECT p FROM VacationPackage p WHERE p.destinationId = ?1", VacationPackage.class);
        List<VacationPackage> resultList = query.setParameter(1, destinationId).getResultList();
        em.close();
        return resultList;
    }

    public static List<VacationPackage> findAllPackages(){
        EntityManager em = entityManagerfactory.createEntityManager();
        TypedQuery<VacationPackage> query = em.createQuery("SELECT p FROM VacationPackage p", VacationPackage.class);
        List<VacationPackage> resultList = query.getResultList();
        em.close();
        return resultList;
    }

    private static String createUpdateQuery() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE VacationPackage SET ");
        int counter = 1;
        for(Field field : VacationPackage.class.getDeclaredFields()) {
            field.setAccessible(true);
            if(!field.getName().equals("id") && !field.getName().equals("vacationDestination")) {
                queryBuilder.append(field.getName()).append(" = ?").append(counter).append(" ,");
                counter++;
            }
        }
        queryBuilder.deleteCharAt(queryBuilder.length()-1);
        queryBuilder.append(" WHERE id = ?").append(counter);
        return queryBuilder.toString();
    }

    public static void updatePackage(VacationPackage vacationPackage) {
        EntityManager em = entityManagerfactory.createEntityManager();
        System.out.println(createUpdateQuery());
        em.getTransaction().begin();
        Query query = em.createQuery(createUpdateQuery())
                .setParameter(1, vacationPackage.getName())
                .setParameter(2, vacationPackage.getPrice())
                .setParameter(3, vacationPackage.getPeriod())
                .setParameter(4, vacationPackage.getExtraDetails())
                .setParameter(5, vacationPackage.getAvailablePlaces())
                .setParameter(6, vacationPackage.getStatus())
                .setParameter(7, vacationPackage.getDestinationId())
                .setParameter(8, vacationPackage.getId());
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
