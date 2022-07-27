package org.example.dao;

import org.example.entity.Client;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClientDAO {

    public static void create(Client c) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(c);
        tx.commit();
    }

    public static Client findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client c = entityManager.find(Client.class, id);
        return c;
    }

    public static List<Client> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Client c");
        return findAllQuery.getResultList();
    }

    public static void delete(Client c) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(c);
        tx.commit();
    }

    public static void deleteCustomerById(Long id) {
        Client c = findById(id);
        delete(c);
    }

    public static void update(Long id, Client data) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client c = entityManager.find(Client.class, id);
        c.setNotNullData(data);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(c);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public static List<Client> findByFirstName(String firstName) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query queryToFindCustomerByFirstName = entityManager.createQuery("select c from Client c where c.firstName = :firstName");
        queryToFindCustomerByFirstName.setParameter("firstName", firstName);
        return queryToFindCustomerByFirstName.getResultList();
    }
}
