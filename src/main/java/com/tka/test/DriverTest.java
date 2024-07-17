package com.tka.test;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Driver;
import com.tka.entity.DriverLicense;

public class DriverTest {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Driver.class);
		cfg.addAnnotatedClass(DriverLicense.class);
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
//		
		Scanner sc=new Scanner(System.in);
		String ch;
		do {
		Transaction transaction=session.beginTransaction();
		
		//Through Scanner class user input
		System.out.println("Enter Id for Driver");
		int id=sc.nextInt();
		
		System.out.println("Enter Name of Driver");
		String name=sc.next();
		
		System.out.println("Enter Year of Birth for Driver");
		int dateOfBirthYear=sc.nextInt();
		System.out.println("Enter Month of Birth for Driver");
		int dateOfBirthMonth=sc.nextInt()-1;
		System.out.println("Enter Day of Birth for Driver");
		int dateOfBirthDay=sc.nextInt();
		
		System.out.println("Enter Contact of Driver");
		String contact=sc.next();
		
		System.out.println("Enter Address of Driver");
		String address=sc.next();
		//License
		System.out.println("Enter Licance Id ");
		int licenseId=sc.nextInt();
		
		System.out.println("Enter Licanse Number");
		String licanceNumber=sc.next();
		
		System.out.println("Enter start Year");
		int startLicenceYear=sc.nextInt();
		System.out.println("Enter Start Month");
		int startLicenceMonth=sc.nextInt()-1;
		System.out.println("Enter Start Day");
		int startLicenceDay=sc.nextInt();
		
		System.out.println("Enter End Year");
		int expLicenceYear=sc.nextInt();
		System.out.println("Enter End Month");
		int expLicenceMonth=sc.nextInt()-1;
		System.out.println("Enter End Year");
		int expLicenceDay=sc.nextInt();
		
		//date 
		
		Calendar driver=Calendar.getInstance();
		driver.set(dateOfBirthYear, dateOfBirthMonth, dateOfBirthDay);
		Date specificTime=driver.getTime();
		
		Calendar licanceStart=Calendar.getInstance();
		licanceStart.set(startLicenceYear, startLicenceMonth, startLicenceDay);
		Date specificTimeOfStart=licanceStart.getTime();
		
		Calendar licanceEnd=Calendar.getInstance();
		licanceEnd.set(expLicenceYear, expLicenceMonth, expLicenceDay);
		Date specificTimeofEnd=licanceEnd.getTime();
		
		//Driver Class object Creation
		Driver driver1=new Driver();
		driver1.setId(id);
		driver1.setName(name);
		driver1.setDateOfBirth(specificTime);
		driver1.setContact(contact);
		driver1.setAddress(address);
		
		//License Class object creation
		DriverLicense license=new DriverLicense();
		license.setLicanceId(licenseId);
		license.setLicanceNumber(licanceNumber);
		license.setIssueDate(specificTimeOfStart);
		license.setExpiryDate(specificTimeofEnd);
		
		//set bidirectional-relationship
		driver1.setDriverLicense(license);
		license.setDriver(driver1);
		
		//save entities
		session.save(driver1);
		session.save(license);
		
		
		transaction.commit();
		
		System.out.println("Do you want to continue(y/n)");
		ch=sc.next();
		}while(ch.equalsIgnoreCase("y"));
		
		
		session.close();
		factory.close();
		sc.close();
	}
}
