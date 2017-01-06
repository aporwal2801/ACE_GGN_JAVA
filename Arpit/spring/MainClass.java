package beanscope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainClass {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		Employee emp = (Employee) ctx.getBean("employeebean");
		emp.setAge(45);
		emp.displayInfo();
		
		Employee emp2 = (Employee) ctx.getBean("employeebean");
		emp2.displayInfo();
		
	}
}
