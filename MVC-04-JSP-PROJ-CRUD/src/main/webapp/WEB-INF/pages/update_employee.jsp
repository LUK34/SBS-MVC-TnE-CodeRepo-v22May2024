<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Report</title>
     <link rel="stylesheet"  href="custom/css/custom_style.css" />
</head>

<body>

	<h1 class="title-color">Update Employee</h1>

	<frm:form modelAttribute="emp">
		
		<table  class="custom-table">
		
		<tbody class="custom-table-body">
			
			<tr>
				<td>Employee Id::</td>
				<td><frm:input path="empno" readonly="true" /></td>
			</tr>
		
			<tr>
				<td>Employee Name::</td>
				<td><frm:input path="ename" /></td>
			</tr>
			
			<tr>
				<td>Employee Desig::</td>
				<td><frm:input path="job" /></td>
			</tr>
			
			<tr>
				<td>Employee Salary::</td>
				<td><frm:input path="sal" /></td>
			</tr>
			
			<tr>
				<td>Employee Dept No::</td>
				<td><frm:input path="deptno" /></td>
			</tr>
			
			<tr>
					<td>	 <input type="submit" value="Update"> </td>
					<td> <input type="reset" value="Cancel"> </td>
			</tr>
		
		</tbody>	
		</table>
		
		
	</frm:form>

		<center>
			<a href="#" onclick="window.history.back()"><img src="images/back.png"  class="button-size">Back</a>&nbsp;&nbsp;&nbsp;
			<a href="./"><img src="images/home.png"  class="button-size">Home</a>&nbsp;&nbsp;&nbsp;
		</center>


</body>

</html>



