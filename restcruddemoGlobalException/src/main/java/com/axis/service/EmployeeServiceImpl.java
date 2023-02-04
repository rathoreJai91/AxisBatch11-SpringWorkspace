package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Employee;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InvalidAgeException;
import com.axis.exception.InvalidSalaryException;
import com.axis.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getAge()<22) {
			throw new InvalidAgeException("Age is less than 23");
		}
		if(employee.getSalary()<=0) {
			throw new InvalidSalaryException("Invalid Salary Input");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Optional<Employee> emp = employeeRepository.findById(id);
		
		if(emp.isPresent())
			return emp.get();
		else
			throw new IdNotFoundException("No Id present to get the value"); 
			
//		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployeeById(int id, Employee employee) {

		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			return employeeRepository.save(employee);
		}else {
			throw new IdNotFoundException("No Id present to Update");
		}
	}

	@Override
	public String deleteEmployeeById(int id) {
		
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee Deleted Successfully";
		}else {
			throw new IdNotFoundException("No Id present Delete");
		}
	}

}
