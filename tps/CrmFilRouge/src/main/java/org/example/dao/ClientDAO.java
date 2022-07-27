package org.example.dao;

import org.example.entity.Client;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClientDAO {
    public static void createClient(Client clientToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(clientToCreate);
        tx.commit();
    }

    public static Client findClientByID(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client clientToFind = entityManager.find(Client.class, id);

        return clientToFind;
    }

    public static List<Client> findAllClients() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Client c");
        return findAllQuery.getResultList();
    }

    public static void deleteClient(Client clientToDelete) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(clientToDelete);
        tx.commit();
    }

    public static void deleteClientById(long id) {
        Client clientToDeleteById = findClientByID(id);
        deleteClient(clientToDeleteById);
    }

    public static void  updateClient(Long id, Client newClientData){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client clientToUpdate = entityManager.find(Client.class, id);
        clientToUpdate.setNotNullData(newClientData);

        EntityTransaction tx = null;
        try{
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(clientToUpdate );
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }
    }

    public static List<Client> findClientByCompanyName(String companyName){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query queryToFindClientByFirstName = entityManager.createQuery("select c from Client c where c.companyName = :companyName");
        queryToFindClientByFirstName.setParameter("companyName", companyName);
        return queryToFindClientByFirstName.getResultList();
    }
}
