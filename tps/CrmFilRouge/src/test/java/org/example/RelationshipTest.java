package org.example;

import org.example.dao.ClientDAO;
import org.example.dao.OrderDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.ClientState;
import org.example.util.OrderState;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class RelationshipTest {

    @Test
    public void manyToOne() {
        Client client = new Client();
        client.setCompanyName("No Company");
        client.setFirstName("No First Name");
        client.setLastName("No Last Name");
        client.setEmail("nomail@mail.org");
        client.setPhone("0000000000");
        client.setAddress("No Road");
        client.setZipCode("00000");
        client.setCity("No City");
        client.setCountry("No Country");
        client.setState(ClientState.ACTIVE);
        ClientDAO.createClient(client);

        Order order = new Order();
        order.setTypePresta("Entrainement");
        order.setDesignation("Sport");
        order.setNbDays(365);
        order.setUnitPrice(20000F);
        order.setState(OrderState.CONFIRMED);
        order.setClient(client);
        OrderDAO.createOrder(order);

        ClientDAO.deleteClientById(client.getId());

        assertNull(OrderDAO.findOrderByID(order.getId()));
    }
}