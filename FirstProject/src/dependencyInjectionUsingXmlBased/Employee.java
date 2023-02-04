package dependencyInjectionUsingXmlBased;

public class Employee {

	int id;
	String name;
	Address address = new Address();
	
	public void displayEmpInfo() {
		System.out.println("id : "+id);
		System.out.println("name : "+name);
		address.streetName();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
