package org.example;

import org.example.dao.ClientDAO;
import org.example.dao.OrderDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.enums.OrderState;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void createOrder() {
        Client marie = new Client("Marie", "Dupont", "Avenue Charles De Gaulle", "75000", "Paris", "France", "a@a.com", "0606060606", "La Poste");
        ClientDAO.create(marie);

        Order o = new Order("Coiffure", "Shampoing et Coupe", 1, 50);
        o.setState(OrderState.OPTION);
        o.setClient(marie);
        OrderDAO.create(o);
        assertNotNull(o.getId());
    }

    @Test
    public void findById() {
        Order o = OrderDAO.findById(1);
        assertNotNull(o);
    }

    @Test
    public void findAll() {
        List<Order> orders = OrderDAO.findAll();
        assertTrue(orders.size() > 0);

        for(Order order: orders){
            System.out.println("");
            System.out.println("************ ORDER: ************");
            System.out.println(order);
            System.out.println("************ Client: ************");
            System.out.println(order.getClient());
        }

    }

    @Test
    public void delete() {

    }

    @Test
    public void deleteCustomerById() {

    }


    @Test
    public void updateCustomer() {

    }


}

