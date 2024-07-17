package com.tka.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Customer;
import com.tka.entity.CustomerOrders;

public class CustTest {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(CustomerOrders.class);
        cfg.addAnnotatedClass(Customer.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Scanner scanner = new Scanner(System.in);

        // Prompt user for Customer details
        System.out.println("Enter Customer ID:");
        int custId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Customer Name:");
        String custName = scanner.nextLine();

        System.out.println("Enter Customer Address:");
        String custAddress = scanner.nextLine();

        Customer customer1 = new Customer(custId, custName, custAddress);

        // Prompt user for Order details
        System.out.println("Enter Order Item:");
        String orderItem = scanner.nextLine();

        System.out.println("Enter Order Year:");
        int year = scanner.nextInt();

        System.out.println("Enter Order Month (1-12):");
        int month = scanner.nextInt() - 1; // Calendar months are zero-based

        System.out.println("Enter Order Day:");
        int day = scanner.nextInt();

        // For creating a specific date
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date specificDate = calendar.getTime();

        CustomerOrders order1 = new CustomerOrders(specificDate, orderItem, customer1);

        session.save(customer1);
        session.save(order1);

        transaction.commit();
        session.close();
        factory.close();
        scanner.close();
    }
}
