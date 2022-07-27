package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Order;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class OrderDAO {

    public static void create(Order o) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(o);
        tx.commit();
    }

    public static Order findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order o = entityManager.find(Order.class, id);
        return o;
    }

    public static List<Order> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select o from Order o");
        return findAllQuery.getResultList();
    }

    public static void delete(Order o) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(o);
        tx.commit();
    }

    public static void deleteById(Long id) {
        Order o = findById(id);
        delete(o);
    }

    public static void update(Long id, Order data) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order o = entityManager.find(Order.class, id);
        o.setNotNullData(data);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(o);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}
