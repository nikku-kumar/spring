package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Address;
import com.tap.pojo.Employee;

@Configuration
public class ConfigFile {
	
	
	@Bean("empi1")
	public Employee createObject1() {
		
		Employee e = new Employee();
		
		e.setId(1);
		e.setName("nikku");
		e.setSalary(50000);
		e.setEmail("nikku@gmail.com");
		return e;
		
	}
	
	
	
	@Bean("addr1")
	public Address createObject2() {
		
		Address a = new Address(24,"bangalore","karnataka","india");
		return a;
		
	}

}
