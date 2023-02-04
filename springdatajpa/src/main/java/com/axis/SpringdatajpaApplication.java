package com.axis;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.axis.entity.Employee;
import com.axis.repository.EmployeeRepository;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Creating an employee
		Employee employee = new Employee();
		employee.setId(2);
		employee.setName("Ramadhir Singh");
		employee.setDept("Bahubali");
		employee.setAge(48);
		employee.setSalary(20000);
		
//		to insert the employee into the database
//		it will create the table if not present and update it
		employeeRepository.save(employee); 
		
//		to fetch the data from the database
		List<Employee> employees = employeeRepository.findAll();
		
		for(Employee employee1 : employees) {
			System.out.println(employee1.getName() +" "+ employee1.getDept());
		}
		System.out.println();
		
//		Fetch data based in Id
		Optional<Employee> emp = employeeRepository.findById(1);
		if(emp.isPresent()) {
			Employee e = emp.get();
//			can also directly from emp object
			System.out.println(e.getId()+" "+e.getName()+" "+e.getDept()+" "+e.getSalary());
		}else {
			System.out.println("No employee is present for this Id");
		}
		
	}

}
