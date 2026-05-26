package com.kodnest.Employee_Mangement_System_Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
	@Column
   String name;
	@Column
   int salary;
	@Column
   String department;
   public Employees() {
	super();
   }
   public Employees(String name, int salary, String department) {
	super();
	this.name = name;
	this.salary = salary;
	this.department = department;
   }
   public Employees(int id, String name, int salary, String department) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.department = department;
   }
   public int getId() {
	return id;
   }
   public void setId(int id) {
	this.id = id;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public int getSalary() {
	return salary;
   }
   public void setSalary(int salary) {
	this.salary = salary;
   }
   public String getDepartment() {
	return department;
   }
   public void setDepartment(String department) {
	this.department = department;
   }
   @Override
   public String toString() {
	return "Employees [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
   }
   
}

