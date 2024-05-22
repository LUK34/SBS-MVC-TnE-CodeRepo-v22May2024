package kw.kng.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import kw.kng.binders.Employee;
import kw.kng.binders.Student;

@Controller
public class HomeController 
{
	//@RequestMapping("/home")
	@RequestMapping("/")
	public String showHome()
	{
		//return Logical View Name
		return "welcome";
	}
	
	@RequestMapping("/process")
	public String process(Map<String, Object> map)//This is the best way of representing SharedMemory becoz it makes the code non-invasive(doesnt spread aggresively)
	{
		System.out.println("HomeController.process() :: ShareMemory Object class name::" +map.getClass());
		map.put("attr", "val1");
		map.put("sysdt", LocalDateTime.now());
		
		return "show_data";
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/process_forward")
	public String process()//source handler
	{
		System.out.println("HomeController.process()");
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showReport()
	{
		System.out.println("HomeController.showReport()");
		return "show_data";
	}
	// ----------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/process_redirect")
	public String redirect(HttpServletRequest req)
	{
		System.out.println("HomeController.redirect()::"+req.hashCode());
		req.setAttribute("attr1", "val1");
		return "redirect:report2";
	}
	
	@RequestMapping("/report2")
	public String showReport(HttpServletRequest req)
	{
		System.out.println("req attribute:: "+req.getAttribute("attr1"));
		System.out.println("HomeController.showReport()");
		return "show_data";
	}
	
	// ----------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/age")
	public String sendData(Map<String, Object> map)
	{
		map.put("name","raja");
		map.put("age", 30);
		return "age";
	}
	
	@GetMapping("/details")
	public String sendDetails(Map<String, Object> map)
	{
		//put arrays, collections as the model attribute values
		map.put("favColors", new String[] {"red","green","yellow"});
		map.put("nickNames", List.of("raja","raj","maharaj"));
		map.put("phoneNumbers", Set.of(99999L,88888L,77777L));
		map.put("idDetails", Map.of("aadharNo",7889999,"voterId",654665464));
	
		//return LVN
		return "details";
	}
	
	
	@RequestMapping("/showJstl")
	public String showJstlPage(Map<String,Object> map)
	{
		//put arrays, collections as the model attribute values
				map.put("favColors", new String[] {"red","green","yellow"});
				map.put("nickNames", List.of("raja","raj","maharaj"));
				map.put("phoneNumbers", Set.of(99999L,88888L,77777L));
				map.put("idDetails", Map.of("aadharNo",7889999,"voterId",654665464));
			
				//return LVN
				return "show_jstl";
	}

	
	@GetMapping("passingModelClassObject")
	public String sendDataAsModelClassObject(Map<String,Object> map)
	{
		System.out.println("Entered the controller of  passing model class object");
		
		Employee emp= new Employee();
		emp.setEno(1001L);
		emp.setEname("Raja");
		emp.setSalary(90000.0);
		emp.setVaccinated(true);
		
		map.put("empInfo", emp);
		
		return "pass_model_class_object";
	}
	
	@GetMapping("passingCollectionOfModelClassObject")
	public String sendCollectionOfModelClassObjects(Map<String,Object> map)
	{
			List<Employee> emplist=List.of(
																new Employee(1001L,"raja",90000.0,true),
																new Employee(1002L,"rajesh",80000.0,true),
																new Employee(1003L,"mahesh",90000.0,true)
																);
			
			//add collection of model class object to model attribute
			map.put("empsListInfo", emplist);
			return "pass_collection_model_class_object";
	}
	
	@GetMapping("/registerStudent")
	public String showForm()
	{
		//return LVN
		return "student_register";
	}
	
	@PostMapping("/registerStudent")
	public String registerStudent(Map<String, Object> map,
													@ModelAttribute("stud") Student st
													)
	{
		System.out.println(st);
		return "show_result";
	}
	
	@GetMapping("/registerStudent2")
	public String showForm2(@ModelAttribute("stud") Student st)
	{
		System.out.println("HomeController.showForm2()");
		System.out.println("Model class object data::"+st);
		//return LVN
		return "student_register2";
	}
	
	@PostMapping("/registerStudent2")//for form submission
	public String processStudent2(Map<String,Object> map,
													@ModelAttribute("stud")Student st)	
	{
			System.out.println("HomeController.processStudent2()");
			System.out.println("Model class object data::"+st);
			
			String grade=null;
			if(st.getAvg()>=75)
			{
				grade="First Class with Dist";
			}
			else if(st.getAvg()>=60)
			{
				grade="First Class";	
			}
			else if(st.getAvg()>=50)
			{
				grade="Second Class";
			}
			else if(st.getAvg()>=35)
			{
				grade="Third Class";
			}
			else
			{
				grade="Fail";
			}
			
			map.put("result", grade);
			
			map.put("studentNo",st.getSno());
			map.put("studentName",st.getSname());
			map.put("studentAddress",st.getSadd());
			map.put("studentAverage",st.getAvg());
			
			return "show_result2";
	}
	
	// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
					//REQUEST_PARAM EXAMPLE
	
	// Link:
	// localhost:4041/MVCFirstApp1/request_param_1?sno=1021&sname=raju
	@GetMapping("/request_param_1")
	public String process(@RequestParam int sno, @RequestParam String sname)
	{
		System.out.println(sno+" "+sname);
		return "show_result3";
	}
	
	
	
	// Link:
	// localhost:4041/MVCFirstApp1/request_param_2?sno=1022&sname=raju
	// localhost:4041/MVCFirstApp1/request_param_2?sno=1022
	@GetMapping("/request_param_2")
	public String process2(@RequestParam int sno, @RequestParam(required=false) String sname)
	{
		System.out.println(sno+" "+sname);
		return "show_result3";
	}//here sname -> since it is required=false
	
	
	
	
	// Link:
	// localhost:4041/MVCFirstApp1/request_param_3?sno=1022
	// localhost:4041/MVCFirstApp1/request_param_3?sno=1022&sname=raju
	@GetMapping("/request_param_3")
	public String process3(@RequestParam int sno, @RequestParam(defaultValue="rrr") String sname)
	{
		System.out.println(sno+" "+sname);
		return "show_result3";
	}//here if sname is not given by default rrr will be taken
	
	
	//Link:
	// localhost:4041/MVCFirstApp1/request_param_4?sno=&sname=raja
	@GetMapping("/request_param_4")
	public String process4(@RequestParam(name="sno",defaultValue="2001") int sno,
										@RequestParam("sname")String sname)
	{
		System.out.println(sno+" "+sname);
		return "show_result3";
	}
	
	//Link:
	// localhost:4041/MVCFirstApp1/request_param_5?sno=1022&sname=raja&sadd=hyd&sadd=vizag&sadd=delhi
	@GetMapping("request_param_5")
	public String process5(@RequestParam(name="sno",required=false)Integer no,
										 @RequestParam("sname")String name,
										 @RequestParam("sadd")String addrs[],
										 @RequestParam("sadd")List<String> saddList,
										 @RequestParam("sadd")Set<String>saddSet)
	{
		System.out.println(no+" "+name+" "+Arrays.toString(addrs)+" "+saddList+" "+saddSet);
		System.out.println("Array to String: "+Arrays.toString(addrs));
		System.out.println("List: "+saddList);
		System.out.println("Set: "+saddSet);
		//return LVN
		return "show_result3";
	}
	
	//Link:
	// localhost:4041/MVCFirstApp1/request_param_6?type=excel
	@GetMapping("request_param_6")
	public String generateReport(@RequestParam(name="type") String type)
	{
		if(type.equalsIgnoreCase("excel"))
		{
			System.out.println("Excel Report");
		}
		else if(type.equalsIgnoreCase("pdf"))
		{
			System.out.println("Pdf Report");
		}
		else
		{
			System.out.println("Unidentified Report");
		}
			return "show_result3";
	}
	
	
	
	
	
	
	
	// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	

}
/*
 DATA RENDERING:
 ->  The process of passing data(results) from controller/handler class to view components(jsp)
 through DS by making the data as model attributes through shared memory is called Data Rendering.
 -> Controller to View component data passing is called Data Rendering.
 
 DATA BINDING:
 -> The process of storing request inputs(form data) to Java bean class/Model class obj is called Data binding.
->  Reading Form data and storing that form data to Java bean class object is called Data Binding.

Calling one handler method from another handler method is called handler method chaning.

In "forward:<path>" ( forward request mode method chaining)
	a) The source handler method and dest handler method use same req, res objects.
	b) The source handler method directly communicates with dest handler method.
	c) The source handler method and dest handler method must be there in the same web application.
	d) Internally used rd.forward.
	
In "redirect:<path>" ( redirecting request mode of method chaining)
	a) The source handler method and dest handler method do not use sme req and res objs
	b) The source handler method communicates with dest handler ,ethod through browser.
	c) The source handler method and dest handler method can be there in the same web application or in 
	2 differnet web applications of the same server or differents servers.
	
	
2 ways of Data Binding:

	2.1) Passing Form data to controller class handler mdethos as Model class object using @ModelAttribute(-) annotation
	2.2) Passing hyperlink supplied additional request param values to handler method params through DispatchServlet using 
	@RequestParam annotation.

2.1) Passing Form data to controller class handler mdethos as Model class object using @ModelAttribute(-) annotation

Internal activities end to end
===============================

#1 &#2) Endusers fills up the form page and submits the form page

#3 &#4) Based on the action path lept in "action" attribute of <form>
tag the DS traps and takes the request

#5)DS hand overs the request to Handler Mapping component.

#6 & #7) Handler mapping component searched form Handler method
in controller classes whose request path is "/register", PostMapping method and 
gets registerStudent(-,-) method signature and relevant controller bean id

#8) HanlderMapping passes controller class bean id and handler method signature back to DS.

#9) Based on Map<String, Object> of Hanlder signature the sharedMemory will be created.



3) Form data binding to Model class object using spring MVC supplied jsp tags

3.1) The form designed using traditional HTML tags support only one way.
Data binding i.e only form submission data goes to Model class object, But Model class object data
does not go to form components as inital values of form comps on the launch of form page.

3.2) To solve this problem design form page by using spring MVC supplied JSP form tags which supports 2 way
binding form submission to Model class Object and Model class object data to form components.

a) Generic JSP Tag libraries:
	(For general purpose operations like reading values from properties file, reading scoped data and etc.)
b) Form JSP tag libraries
	(For Form designing with the support of 2 way binding)
	
	







  */