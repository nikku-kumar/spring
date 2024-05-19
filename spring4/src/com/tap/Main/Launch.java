package com.tap.Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tap.config.ConfigFile;
import com.tap.pojo1.Employee1;
import com.tap.pojo2.Student;

public class Launch {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(ConfigFile.class);
		Employee1 e = a.getBean(Employee1.class);
		Student s = a.getBean(Student.class);
		System.out.println(s);
		System.out.println(e);

	}

}
