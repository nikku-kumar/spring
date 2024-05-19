package com.tap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tap.pojo.Employee;

@Configuration
public class ConfigFile {
	
//	  @Bean
//      public Employee empI1()
//      {
//    	  Employee e = new Employee();
//    	  return e;
//      }
	
	
	@Bean("empI1")
  public Employee createObject1()
  {
	  Employee e = new Employee();
	  e.setId(1);
	  e.setName("nikku");
	  e.setEmail("nikku@gmail.com");
	  e.setSalary(1000000);
	  return e;
  }
	
	@Bean("empI2")
	  public Employee createObject2()
	  {
		  Employee e = new Employee();
		  e.setId(2);
		  e.setName("ankit");
		  e.setEmail("ankit@gmail.com");
		  e.setSalary(1000000);
		  return e;
	  }
	
	
}
