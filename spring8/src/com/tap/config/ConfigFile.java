package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Address;
import com.tap.pojo.Collegue;
import com.tap.pojo.Employee;

@Configuration
public class ConfigFile {
	
	
	@Bean("empid1")
	public Employee createObject() {
		
		
		Employee e = new Employee();
		e.setId(1);
		e.setName("nikku");
		e.setEmail("nikku@gmail.com");
		e.setSalary(5000000);
		return e;
	}
	
	@Bean("addr1")
	public Address createObject2() {
	  
		 Address a = new Address(54,"bangalore", "karnataka", "india");
		 return a;
	}
	
	@Bean("addr2")
	public Address createObject3() {
	  
		 Address a = new Address(56,"btm", "krpuram", "india");
		 return a;
	}
	
	
	@Bean("coll1")
	public Collegue createObject4() {
		Collegue c = new Collegue("nikku", "ankit", "amit", "shubham");
		return c;
	}

}
