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

<h1 style="color:red; text-align:center">Student Register Form Data Binding Page</h1>


<form action="registerStudent" method="POST">
<table align="center" bgcolor="cyan">
	<tr>
		<td>Student Number:</td>
		<td> <input type="text" name="sno" />  </td>
	</tr>
	
	<tr>
		<td>Student Name:</td>
		<td>  <input type="text" name="sname" />  </td>
	</tr>
	
	<tr>
		<td>Student Address:</td>
		<td> <input type="text" name="saddr" />  </td>
	</tr>
	
	<tr>
		<td>Student Average:</td>
		<td> <input type="text" name="avg" />  </td>
	</tr>

	<tr  style="text-align:center">
		<td colspan="2">
			<input type="submit" value="Register" />
		</td>
	</tr>
</table>
		
</form>

<h3 style="text-align:center"><a href="./">Main Page</a></h3>&nbsp;&nbsp;

	
</body>
</html>