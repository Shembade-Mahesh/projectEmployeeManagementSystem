package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeRepository;
import com.model.Employee;

@Service
public class EmployeeService implements EmployeeIntService {

	@Autowired
	EmployeeRepository EmployeeRepo;
	
	public Employee addEmployee(Employee employee) {
		
		return EmployeeRepo.save(employee);
	}

	
	public Employee updateEmployee(Employee employee) {
		Employee empl=EmployeeRepo.findById(employee.getId()).orElse(null);
		empl.setFirstName(employee.getFirstName());
		empl.setLastName(employee.getLastName());
		empl.setEmailId(employee.getEmailId());
		return EmployeeRepo.save(empl);
	}

	
	public List<Employee> listEmpolyee() {
		List<Employee> list=EmployeeRepo.findAll();
		return list;
	}

	
	public void deleteEmployee(int empId) {
		EmployeeRepo.deleteById(empId);
		
	}

	public Employee getOneEmployee(int id) {
		
		return EmployeeRepo.findById(id).orElse(null);
	}


	@Override
	public Employee getEmployee(String emailId) {
		
		return EmployeeRepo.findByEmailId(emailId);
	}

}
