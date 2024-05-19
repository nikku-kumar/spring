package com.tap.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		
		 String confgLoc = "/com/tap/config/applicationContext.xml";
         ApplicationContext c = new ClassPathXmlApplicationContext(confgLoc);
         
         Employee e = (Employee)c.getBean("empi1");
         System.out.println(e);

	}

}
