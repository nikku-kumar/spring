package com.tap.pojo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee1 {
	
	@Value("1")
	private int id;
	
	@Value("nikku")
	private String name;
	
	@Value("nikku@gmail.com")
	private String email;
	
	@Value("5000000")
	private int salary;
	
	
	public Employee1() {
		
	}


	public Employee1(int id, String name, String email, int salary) {
		super();
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
	
	@Override
	public String toString() {
		
		return  id+" "+name+" "+email+" "+salary;
		
		
		}
}
