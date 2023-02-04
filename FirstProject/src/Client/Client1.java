package Client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import dependencyInjectionUsingXmlBased.Employee;

public class Client1 {

	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		Employee employee = (Employee) factory.getBean("emp");
		employee.displayEmpInfo();	
	}	
}
