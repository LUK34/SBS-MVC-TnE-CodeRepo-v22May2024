package kw.kng.service;

import kw.kng.entities.Employee;

public interface EmployeeService
{
	
	Iterable<Employee> getAllEmployee();
	String registerEmployee(Employee emp);
	String updateEmployee(Employee emp);
	Employee getEmployeeById(Long eno);
	String deleteEmployeeById(Long eno);
	
}
