package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;

import com.service.EmployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/EmployeeMangement")
public class TestEmployee {
	 
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
//		String tempEmail =employee.getEmailId();
//		if(tempEmail !=null && !"".equals(tempEmail)) {
//			Employee employeeObj=employeeService.getEmployee(tempEmail);
//			if(employeeObj!=null) {
//				throw new Exception("User with "+tempEmail+" is already exit");
//			}
//		}
//		Employee employeeObj1=null;
//		employeeObj1=employeeService.addEmployee(employee);
//		return employeeObj1;
//		
		return employeeService.addEmployee(employee);
	}
	
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@GetMapping("/Employeelist")
	public List<Employee> employeeDetails(){
		return employeeService.listEmpolyee();
	}
	@DeleteMapping("Delete/{empId}")
	public void removeEmployee(@PathVariable int empId) {
		employeeService.deleteEmployee(empId);
	}
	
	@GetMapping("EmployeeD/{emailId}")
	public Employee getOneEmployee( @PathVariable String emailId) {
		return employeeService.getEmployee(emailId);
	}
	@GetMapping("EmployeeDetails/{empId}")
	public Employee getOneEmployee(@PathVariable int empId) {
		return employeeService.getOneEmployee(empId);
	}
	

}
