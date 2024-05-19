package com.tap.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		
		 String configloc = "/com/tap/config/applicationContext.xml";
		 ApplicationContext context = new ClassPathXmlApplicationContext(configloc);
		 Employee e = (Employee)context.getBean("empI1");
		 Employee e1 = (Employee)context.getBean("empI2");
		 System.out.println(e);
		 System.out.println(e1);
		 	
		 
		 
	}

}
