package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeIntService  {
	 Employee addEmployee(Employee employee);
	 Employee updateEmployee(Employee employee);
	 List<Employee> listEmpolyee();
	 void deleteEmployee(int id);
	 Employee getOneEmployee(int id);
	 Employee getEmployee(String emailId);
	

}
