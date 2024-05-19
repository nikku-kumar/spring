package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Address;
import com.tap.pojo.Employee;

@Configuration
public class ConfigFile {
	
	@Bean("addrId1")
	public Address createObject1() 
	{
		Address a = new Address();
		a.setLaneNo(24);
		a.setCity("bangalore");
		a.setState("karnataka");
		a.setCountry("india");
		
		return a;
	}
	
	
	@Bean ("empid1")
	public Employee createObject2()
	{
		Employee e = new Employee(1,"nikku","nikku@gmail.com",500000,createObject1());
		
		return e;
	}
	

}
