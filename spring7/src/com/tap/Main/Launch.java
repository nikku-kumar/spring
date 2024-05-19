package com.tap.Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tap.config.ConfigFile;
import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(ConfigFile.class);
		Employee e =(Employee) a.getBean("empi1");
		System.out.println(e);

	}

}
