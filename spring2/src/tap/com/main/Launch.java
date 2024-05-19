package tap.com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tap.config.ConfigFile;
import com.tap.pojo.Employee;

public class Launch {

	public static void main(String[] args) {
		
		
		 AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(ConfigFile.class);
		 Employee e = (Employee)a.getBean("empI1");
		 System.out.println(e);
		 
		 Employee e1 = (Employee)a.getBean("empI2");
		 System.out.println(e1);
	}

}
