package kw.kng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.entities.Employee;
import kw.kng.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepo erepo;
	
	@Override
	public Iterable<Employee> getAllEmployee()
	{
		return erepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) 
	{
		return "Employee is saved with id value"+erepo.save(emp).getEmpno();
	}
	
	
	

	@Override
	public Employee getEmployeeById(Long eno) 
	{
		Employee emp=erepo.findById(eno).orElseThrow(()-> new IllegalArgumentException());
		
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) 
	{
		return "Employee is updated with having id value:: "+erepo.save(emp).getEmpno();
	}

	@Override
	public String deleteEmployeeById(Long eno) 
	{
		erepo.deleteById(eno);
		return "Employee with id "+eno+"is deleted";
	}
	
}
