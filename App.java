package com.kodnest.Employee_Mangement_System_Hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
	
	public static SessionFactory factory=null;
	static final Scanner sc=new Scanner(System.in);
	
	static {
		factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public void addEmployee() {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("Name Salary and Department..");
		String name=sc.next();
		int salary=sc.nextInt();
		String department=sc.next();
		Employees e=new Employees(name, salary, department);
		session.persist(e);
		transaction.commit();
		session.close();
		
	}
	
	public Employees getEmployee() {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("Enter the id ");
		Employees ref=session.get(Employees.class, sc.nextInt());
		System.out.println(ref);
		transaction.commit();
		session.close();
		
		return ref;
	}
	
	public void deletEmployee() {
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Employees ref=getEmployee();
		if(ref!=null) {
			session.remove(ref);
		}else {
			System.out.println("Entered invalied id..");
		}
		transaction.commit();
		session.close();
		
	}
	
	public void updateEmployee() {
		
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("Enter the id to update");
		Employees ref=getEmployee();
		System.out.println("press-->1 to update Name");
		System.out.println("press-->2 to update salary");
		System.out.println("press-->3 to update Department");
		int ch=sc.nextInt();
		switch(ch) {
		case 1: 
			System.out.println("Enter New Name");
			String name=sc.next();
			ref.setName(name);
			ref=session.merge(ref);
			System.out.println(ref);
			transaction.commit();
			session.close();
			
			break;
		case 2:
			System.out.println("Enter the salary to update");
			int salary=sc.nextInt();
			ref.setSalary(salary);
			ref=session.merge(ref);
			System.out.println(ref);
			transaction.commit();
			session.close();
		
			break;
			
		case 3:
			System.out.println("Enter the Dapertment to update..");
			String department=sc.next();
			ref=session.merge(ref);
			System.out.println(ref);
			transaction.commit();
			session.close();
			
			break;
			
		default :
			System.out.println("Wrong choice go again");
			updateEmployee();
		}
		
	
	}
    public static void main(String[] args) {
    	App app=new App();
        System.out.println("Welcome To Emloyees Mangement System..");
        while(true) {
        System.out.println("Menu");
        System.out.println("Press 1 to AddEmployees..");
        System.out.println("Press 2 to GetEmployees..");
        System.out.println("Press 3 to deleteEmployees..");
        System.out.println("Press 4 to UpdateEmployees..");
        
        int chi=sc.nextInt();
        switch(chi) {
        case 1: app.addEmployee();
             break;
        case 2: app.getEmployee();
             break;
        case 3: app.deletEmployee();
             break;
        case 4: app.updateEmployee();
             break;
        default :
        	System.out.println("Wrong Choice..");
        }
        
        }
        
    }
}
