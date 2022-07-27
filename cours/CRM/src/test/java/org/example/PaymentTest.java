package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDAO;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PaymentTest {
    @Test
    public void createPayment()
    {
        Payment payment1 = new Payment();
        payment1.setCardNumber("123 456 789");
        payment1.setConfidentialCode("0000");
        payment1.setBank("M2I");
        PaymentDAO.create(payment1);

        Payment payment2 = new Payment();
        payment2.setCardNumber("789 123 456");
        payment2.setConfidentialCode("0000");
        payment2.setBank("JAVA");
        PaymentDAO.create(payment2);

        Payment payment3 = new Payment();
        payment3.setCardNumber("456 789 123");
        payment3.setConfidentialCode("0000");
        payment3.setBank("SOPRA");
        PaymentDAO.create(payment3);

        System.out.println(payment1);
        System.out.println(payment2);
        System.out.println(payment3);

        assertTrue( true );
    }

    @Test
    public void findByID(){
        Payment payment = new Payment();
        payment.setCardNumber("123 456 789");
        payment.setConfidentialCode("0000");
        payment.setBank("M2I");
        PaymentDAO.create(payment);

        Payment payment1  = PaymentDAO.findByID(payment.getId());
        assertEquals("0000", payment1.getConfidentialCode());
        //assertEquals("M2I", payment1.getBank());
    }

    @Test
    public void findAll(){
        PaymentDAO.create(new Payment("M2I"));
        PaymentDAO.create(new Payment("JAVA"));
        PaymentDAO.create(new Payment("SOPRA"));

        List<Payment> payments = PaymentDAO.findAll();
        assertEquals(3, payments.size());
    }

    @Test
    public void deletePayment(){
        Payment lcl = new Payment("LCL");
        PaymentDAO.create(lcl);

        List<Payment> payments = PaymentDAO.findAll();
        assertEquals(1, payments.size());

        PaymentDAO.delete(lcl);

        payments = PaymentDAO.findAll();
        assertEquals(0, payments.size());
    }
}
