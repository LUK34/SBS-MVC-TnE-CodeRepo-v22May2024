package kw.kng.controllers;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kw.kng.entities.Employee;
import kw.kng.service.EmployeeService;

@Controller
public class EmployeeOperationsController 
{
	
	@Autowired
	private EmployeeService es;
	
	//Link:
	//http://localhost:4041/emp_crud/
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String,Object> map)
	{
		System.out.println("=============>  EmployeeOperationsController.showEmployeeReport()");
		
		Iterable<Employee> itEmps=es.getAllEmployee();
		
		//put result in model attribute
		map.put("empsList", itEmps);	
	
		//return LVN
		return "show_employee_report";
	}
	
	@GetMapping("/emp_add")
	public String showFormForGetEmployee(@ModelAttribute("emp") Employee emp)
	{
		System.out.println("=============>  EmployeeOperationsController.showFormForGetEmployee()");
		return "register_employee";
	}

	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,
													RedirectAttributes attrs
													)
	{
		System.out.println("=============> EmployeeOperationsController.saveEmployee()");	
		//use Service
		String msg=es.registerEmployee(emp);
		/*
		 Keep the result as flashAttribute. The RedirectAttributes is a shared Memory which
		 hold the attributes only during coarse of Redirection. i.e once the redirection is over.
		 Attributes in this special shared memory will be vanished. So these attributes are called
		 FlashAttributes. 
		*/
		//return LVN
		return "redirect:emp_report";
	}
	
	@GetMapping("emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no") Long eno,
																			@ModelAttribute("emp")Employee emp)
	{
		System.out.println("=============> EmployeeOperationsController.showEditEmployeeFormPage()");
		
		//use Service
		Employee emp1 = es.getEmployeeById(eno);
		
		System.out.println("Employee Details "+emp1);
		
		//copy data
		BeanUtils.copyProperties(emp1, emp);
		
		//Return LVN
		return "update_employee";
	}
	
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,
													@ModelAttribute("emp") Employee emp)
	{
		System.out.println("=============> EmployeeOperationsController.editEmployee()");
		
		//user service
		String msg=es.updateEmployee(emp);
		
		//add the result message as Flash Attribute
		attrs.addFlashAttribute("resultMsg", msg);
		
		//redirect the redirect
		return "redirect:emp_report";
	}
	
	@GetMapping("/emp_delete")
	public String deleteEmployee(RedirectAttributes attrs,
														@RequestParam Long no)
	{
		System.out.println("=============> EmployeeOperationsController.deleteEmployee()");
		
		//use service
		String msg=es.deleteEmployeeById(no);
		
		//Keep the result in FlashAttribute
		attrs.addFlashAttribute("resultMsg", msg);
		
		//redirect the request
		return "redirect:emp_report";
	}

}

/*
 PRG Pattern Implementation:
 ==========================
 Redirect the request to GET Mode Handler method from POST mode handler method using 
 handler method chaining concept..So when we press refresh button the GET Mode requesy handler method will be repeated
 which will not give any side effect becoz the Get Mode request method performs generally select the data operation
 which is not going to be a problem.
 
 The flashAttributes kept in RedirectAttribute object are visible and accessible in the dest handler method and its LVN
 related to view component(JSP page) only. Till the end of redirection activity. i.e next request will be given after redirection activity.
 
 
 
 */
