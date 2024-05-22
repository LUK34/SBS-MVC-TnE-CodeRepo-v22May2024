<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Report</title>
     <link rel="stylesheet"  href="custom/css/custom_style.css" />
    
    
</head>
<body>


	<c:choose>
	
		<c:when test="${!empty empsList}">
			<h1  class="title-color">Employee Report</h1>
			<table class="custom-table">
				
				<thead class="custom-table-header">
					<tr>
						<th>Employee Id</th>
						<th>Employee Name</th>
						<th>Job</th>
						<th>Salary</th>
						<th>Dept no</th>
						<th>Action</th>
					</tr>
				</thead>
				
				<tbody class="custom-table-body">
					<c:forEach var="emp" items="${empsList}">
						<tr>
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.job}</td>
							<td>${emp.sal}</td>
							<td>${emp.deptno}</td>
							<td> 
							
									<a href="emp_edit?no=${emp.empno}">
										  	<img src="images/pencil.png" class="button-size">
									</a>	
							
									<a href="emp_delete?no=${emp.empno}"
										  onclick="return confirm('Do you want to delete the employee')">
										  	<img src="images/dustbin.png" class="button-size">
									</a>	
									  	
							</td>
						</tr>
					</c:forEach>
			 </tbody>
				
			</table>
		</c:when>		
			
		<c:otherwise>
			<h1 style="color:red;text-align:center">Employee Not found</h1>
		</c:otherwise>

	</c:choose>

	<center>
			<a href="emp_add"><img src="images/plus.png"  class="button-size">Add Employee</a>&nbsp;&nbsp;&nbsp;
			
			<a href="#" onclick="window.history.back()"><img src="images/back.png"  class="button-size">Back</a>&nbsp;&nbsp;&nbsp;
			
			<a href="./"><img src="images/home.png"  class="button-size">Home</a>&nbsp;&nbsp;&nbsp;
	
	</center>



	
</body>
</html>