<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expression Language Example</title>
</head>
<body>

<h1 style="color:red; text-align:center">RESULT -> Student Register Form Data Binding Page using spring supplied JSP form tags -> 2 way data binding</h1>

<br>
	<div style="text-align:center">
		<b>Student Result:: ${result} </b>
		
		<table align="center" bgcolor="cyan">
				<tr>
					<td>Student Number:</td>
					<td>${studentNo}</td>
				</tr>
				
				<tr>
					<td>Student Name:</td>
					<td>${studentName} </td>
				</tr>
				
				<tr>
					<td>Student Address:</td>
					<td> ${studentAddress} </td>
				</tr>
				
				<tr>
					<td>Student Average:</td>
					<td> ${studentAverage}   </td>
				</tr>
			
		</table>
	</div>
</br>

<h3 style="text-align:center"><a href="./">Main Page</a></h3>&nbsp;&nbsp;

</body>
</html>
