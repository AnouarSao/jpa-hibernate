package org.example;

import org.example.dao.ClientDAO;
import org.example.dao.OrderDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.ClientState;
import org.example.util.OrderState;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class ClientTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void createClient()
    {
        Client client = new Client();

        client.setCompanyName("NoCompany");
        client.setFirstName("Anouar");
        client.setLastName("Sao");
        client.setEmail("anouar.sao@mail.org");
        client.setPhone("0000000000");
        client.setAddress("No Road");
        client.setZipCode("00000");
        client.setCity("No City");
        client.setCountry("No Country");
        client.setState(ClientState.ACTIVE);

        ClientDAO.createClient(client);

        assertTrue( true );
    }

    @Test
    public void findClientByID(){
        Client client = new Client();

        client.setCompanyName("NoCompany");
        client.setFirstName("Anouar");
        client.setLastName("Sao");
        client.setEmail("anouar.sao@mail.org");
        client.setPhone("0000000000");
        client.setAddress("No Road");
        client.setZipCode("00000");
        client.setCity("No City");
        client.setCountry("No Country");
        client.setState(ClientState.ACTIVE);

        ClientDAO.createClient(client);
        Client client1 = ClientDAO.findClientByID(client.getId());
        assertEquals("Anouar", client1.getFirstName());
    }

    @Test
    public void dontFindClientById() {
        Client client = ClientDAO.findClientByID(9);
        assertNull(client);
    }
    @Test
    public void findAllClients() {

        List<Client> clients = ClientDAO.findAllClients();
        assertTrue(clients.size() > 0);
    }

    @Test
    public void deleteClient(){

        Client client = new Client();
        client.setCompanyName("Sopra Steria");
        client.setFirstName("Marion");
        client.setLastName("Perez");
        client.setPhone("0786842676");
        client.setEmail("marioncanelle2@gmail.com");
        client.setAddress("1234 rue de la mairie");
        client.setZipCode("31700");
        client.setCity("Blagnac");
        client.setCountry("France");
        client.setState(ClientState.ACTIVE);
        ClientDAO.createClient(client);

        List<Client> clients = ClientDAO.findAllClients();
        int listLength = clients.size();

        ClientDAO.deleteClient(client);

        clients = ClientDAO.findAllClients();
        assertEquals(listLength - 1, clients.size());
    }

    @Test
    public void deleteClientById() {

        Client client1 = new Client();
        client1.setCompanyName("Sopra Steria");
        client1.setFirstName("Marion");
        client1.setLastName("Perez");
        client1.setPhone("0786842676");
        client1.setEmail("marioncanelle2@gmail.com");
        client1.setAddress("1234 rue de la mairie");
        client1.setZipCode("31700");
        client1.setCity("Blagnac");
        client1.setCountry("France");
        client1.setState(ClientState.ACTIVE);
        ClientDAO.createClient(client1);

        Client client2 = new Client();
        client2.setCompanyName("Sopra Steria");
        client2.setFirstName("Ludovic");
        client2.setLastName("Raulin");
        client2.setPhone("0123456789");
        client2.setEmail("lraulin843@gmail.com");
        client2.setAddress("1234 rue de l'eglise");
        client2.setZipCode("67000");
        client2.setCity("Strasbourg");
        client2.setCountry("France");
        client2.setState(ClientState.ACTIVE);
        ClientDAO.createClient(client2);

        ClientDAO.deleteClientById(client1.getId());

        assertNull(ClientDAO.findClientByID(client1.getId()));
        assertNotNull(ClientDAO.findClientByID(client2.getId()));

        ClientDAO.deleteClientById(client2.getId());
    }
    @Test
    public void updateClient() {

        Client client = new Client();
        client.setCompanyName("Sopra Steria");
        client.setFirstName("Marion");
        client.setLastName("Perez");
        client.setPhone("0786842676");
        client.setEmail("marioncanelle2@gmail.com");
        client.setAddress("1234 rue de la mairie");
        client.setZipCode("31700");
        client.setCity("Blagnac");
        client.setCountry("France");
        client.setState(ClientState.ACTIVE);
        ClientDAO.createClient(client);

        Client newClientData = new Client();
        newClientData.setEmail("marion.oceane.perez@gmail.com");
        ClientDAO.updateClient(client.getId(), newClientData);

        Client updatedCustomer = ClientDAO.findClientByID(client.getId());
        assertEquals("marion.oceane.perez@gmail.com", updatedCustomer.getEmail());

        ClientDAO.deleteClient(client);
    }

    @Test
    public void findClientByCompanyName() {

        Client client1 = new Client();
        client1.setCompanyName("Test");
        client1.setFirstName("Marion");
        client1.setLastName("Perez");
        client1.setPhone("0786842676");
        client1.setEmail("marioncanelle2@gmail.com");
        client1.setAddress("1234 rue de la mairie");
        client1.setZipCode("31700");
        client1.setCity("Blagnac");
        client1.setCountry("France");
        client1.setState(ClientState.ACTIVE);
        ClientDAO.createClient(client1);

        Client client2 = new Client();
        client2.setCompanyName("Test");
        client2.setFirstName("Ludovic");
        client2.setLastName("Raulin");
        client2.setPhone("0123456789");
        client2.setEmail("lraulin843@gmail.com");
        client2.setAddress("1234 rue de l'eglise");
        client2.setZipCode("67000");
        client2.setCity("Strasbourg");
        client2.setCountry("France");
        client2.setState(ClientState.ACTIVE);
        ClientDAO.createClient(client2);

        Client client3 = new Client();
        client3.setCompanyName("Pas test");
        client3.setFirstName("Valentin");
        client3.setLastName("Payet");
        client3.setPhone("0987654321");
        client3.setEmail("valentinpayet06@gmail.com");
        client3.setAddress("321 rue de l'ecole");
        client3.setZipCode("33000");
        client3.setCity("Bordeaux");
        client3.setCountry("France");
        client3.setState(ClientState.INACTIVE);
        ClientDAO.createClient(client3);

        List<Client> testCompany = ClientDAO.findClientByCompanyName("Test");
        assertEquals(2, testCompany.size());

        ClientDAO.deleteClient(client1);
        ClientDAO.deleteClient(client2);
        ClientDAO.deleteClient(client3);
    }

}
