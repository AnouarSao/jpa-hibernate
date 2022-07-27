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
public class OrderTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void createOrder() {
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

        Order order = new Order();
        order.setTypePresta("Formation Test");
        order.setDesignation("Angular");
        order.setNbDays(5);
        order.setUnitPrice(950F);
        order.setState(OrderState.CONFIRMED);
        order.setClient(client);
        OrderDAO.createOrder(order);

        assertTrue(true);

    }
    @Test
    public void DontFindOrderById() {

        Order order = OrderDAO.findOrderByID(10);
        assertNull(order);
    }

    @Test
    public void findAllOrders() {

        List<Order> orders = OrderDAO.findAllOrder();
        assertTrue(orders.size() > 0);
    }

    @Test
    public void deleteOrder(){

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

        Order order = new Order();
        order.setTypePresta("Formation Test");
        order.setDesignation("Angular");
        order.setNbDays(5);
        order.setUnitPrice(950F);
        order.setState(OrderState.CONFIRMED);
        order.setClient(client);
        OrderDAO.createOrder(order);

        List<Order> orders = OrderDAO.findAllOrder();
        int listLength = orders.size();

        OrderDAO.deleteOrder(order);

        orders = OrderDAO.findAllOrder();
        assertEquals(listLength, orders.size());

        ClientDAO.deleteClient(client);
    }

    @Test
    public void updateOrder() {

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

        Order order = new Order();
        order.setTypePresta("Formation Test");
        order.setDesignation("Angular");
        order.setNbDays(5);
        order.setUnitPrice(950F);
        order.setState(OrderState.CONFIRMED);
        order.setClient(client);
        OrderDAO.createOrder(order);

        Order newOrderData = new Order();
        newOrderData.setUnitPrice(999.99F);
        OrderDAO.updateOrder(order.getId(), newOrderData);

        Order updatedOrder = OrderDAO.findOrderByID(order.getId());
        assertEquals(new Float(999.99F), updatedOrder.getUnitPrice());

        ClientDAO.deleteClient(client);
    }
}