package com.tap.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	
	private int id;
	private String name;
	private String email;
	private int salary;
	
	
	@Autowired
	@Qualifier("addr2")
	private Address  address;
	

	public Employee() {
		
	}

	public Employee(int id, String name, String email, int salary,Address address) {
		super();
		System.out.println("constructor called");
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.address= address;
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}
    
	
	
	public void setAddress(Address address) {
		this.address = address;
	}

	
}
