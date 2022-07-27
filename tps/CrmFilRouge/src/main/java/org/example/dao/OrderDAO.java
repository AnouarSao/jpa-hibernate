package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Order;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class OrderDAO {
    public static void createOrder(Order orderToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(orderToCreate);
        tx.commit();
    }

    public static Order findOrderByID(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order orderToFind = entityManager.find(Order.class, id);

        return orderToFind;
    }

    public static List<Order> findAllOrder() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Client c");
        return findAllQuery.getResultList();
    }

    public static void deleteOrder(Order orderToDelete) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(orderToDelete);
        tx.commit();
    }

    public static void deleteOrderById(long id) {
        Order orderToDeleteById = findOrderByID(id);
        deleteOrder(orderToDeleteById);
    }

    public static void  updateOrder(Long id, Order newOrderData){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order orderToUpdate = entityManager.find(Order.class, id);
        orderToUpdate.setNotNullData(newOrderData);

        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(orderToUpdate );
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }
    }

    public static List<Order> findOrderByClient(Client client){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query queryToFindClientByClient = entityManager.createQuery("select o from Order o where o.client = :client");
        queryToFindClientByClient.setParameter("client", client);
        return queryToFindClientByClient.getResultList();
    }
}
