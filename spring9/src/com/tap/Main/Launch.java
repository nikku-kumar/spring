package com.tap.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		
		
		String conloc = "/com/tap/config/applicationContext.xml";
		ApplicationContext c = new ClassPathXmlApplicationContext(conloc);
		
		Employee e = (Employee)c.getBean("empi1");
		Employee e1 = (Employee)c.getBean("empi1");
		Employee e2 = (Employee)c.getBean("empi1");
		System.out.println(e);
		System.out.println(e1);
		System.out.println(e2);
		

	}

}
