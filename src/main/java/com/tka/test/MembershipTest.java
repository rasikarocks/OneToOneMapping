package com.tka.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Members;
import com.tka.entity.Membership;

public class MembershipTest{
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Members.class);
        cfg.addAnnotatedClass(Membership.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Scanner sc = new Scanner(System.in);
        String ch;
        do {
            Transaction transaction = session.beginTransaction();
            
            // for members details
            System.out.println("Enter Id of Member:");
            int memberId = sc.nextInt();
            
            System.out.println("Enter First Name of Member:");
            String firstName = sc.next();
            
            System.out.println("Enter Last Name of Member:");
            String lastName = sc.next();
            
            System.out.println("Enter email of Member:");
            String email = sc.next();
            
            System.out.println("Enter phone number of Member:");
            String phoneNumber = sc.next();  // Read as String
            
            // for Membership Details
            System.out.println("Enter Id of Membership:");
            int membershipId = sc.nextInt();
            
            System.out.println("Enter type of Membership:");
            String membershipType = sc.next();
            
            System.out.println("Enter Start Year of Membership:");
            int startYear = sc.nextInt();

            System.out.println("Enter Start Month of Membership:");
            int startMonth = sc.nextInt() - 1;
            
            System.out.println("Enter Start Day of Membership:");
            int startDay = sc.nextInt();
            
            System.out.println("Enter End Year of Membership:");
            int endYear = sc.nextInt();

            System.out.println("Enter End Month of Membership:");
            int endMonth = sc.nextInt() - 1;
            
            System.out.println("Enter End Day of Membership:");
            int endDay = sc.nextInt();
            
            // Calendar
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.set(startYear, startMonth, startDay);
            Date specificStartDate = startCalendar.getTime();
            
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.set(endYear, endMonth, endDay);
            Date specificEndDate = endCalendar.getTime();
            
            // Create entities
            Members member = new Members();
            member.setId(memberId);
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setEmail(email);
            member.setPhoneNumber(phoneNumber);

            Membership membership = new Membership();
            membership.setMembershipId(membershipId);
            membership.setMambershipType(membershipType);
            membership.setStartDate(specificStartDate);
            membership.setEndData(specificEndDate);
            
            // Set bi-directional relationship
            member.setMembership(membership);
            membership.setMembers(member);
            
            // Save entities
            session.save(member);
            session.save(membership);
            
            transaction.commit();
            
            System.out.println("Do you want to continue(y/n)");
            ch = sc.next();
        } while (ch.equalsIgnoreCase("y"));
        
        session.close();
        factory.close();
        sc.close();
    }
}
