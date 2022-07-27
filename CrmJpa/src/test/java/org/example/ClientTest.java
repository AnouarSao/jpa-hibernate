package org.example;

import org.example.dao.ClientDAO;
import org.example.entity.Client;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void createClient() {
        Client marie = new Client("Marie", "Dupont", "Avenue Charles De Gaulle", "75000", "Paris", "France", "a@a.com", "0606060606", "La Poste");
        ClientDAO.create(marie);
        assertNotNull(marie.getId());
    }

    @Test
    public void findById() {
        Client c = ClientDAO.findById(1);
        assertNotNull(c.getFirstName());
    }

    @Test
    public void findAll() {
        List<Client> clients = ClientDAO.findAll();
        assertTrue(clients.size() > 0);
    }

    @Test
    public void deleteClient() {
        Client marie = new Client("Marie", "Dupont", "Avenue Charles De Gaulle", "75000", "Paris", "France", "a@a.com", "0606060606", "La Poste");
        ClientDAO.create(marie);

        List<Client> clients = ClientDAO.findAll();
        int countBeforeDeletion = clients.size();

        ClientDAO.delete(marie);

        clients = ClientDAO.findAll();
        assertEquals(countBeforeDeletion-1, clients.size());
    }
}

