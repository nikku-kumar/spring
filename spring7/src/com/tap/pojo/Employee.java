package com.tap.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	private int id;
	private String name;
	private String email;
	private int salary;
	
	@Autowired
	private Address  address;

	public Employee() {
		
	}

	public Employee(int id, String name, String email, int salary) {
		super();
		System.out.println("cons");
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		
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

	
	@Override
	public String toString() {
		
		return id+" "+name+" "+email+" "+salary+" "+address;
	}


}
