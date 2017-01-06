package di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainClass {
	
	public static void main(String[] args) {
//		Resource resource = new ClassPathResource("beans.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		HelloWorld hello = (HelloWorld) ctx.getBean("hellobean");
		hello.displayInfo();
	}
}
