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

	<h1 style="color:red; text-align:center">Passing collection with Model Class Objects Page</h1>
	<c:choose>
		<c:when test="${!empty empsListInfo}">
			<table border="1" bgcolor="cyan" align="center">
				<tr>
						<th>eno</th>
						<th>ename</th>
						<th>salary</th>
						<th>isVaccinated</th>
				</tr>
				<c:forEach var="emp" items="${empsListInfo}">
				<tr>
						<td>${emp.eno}</td>
						<td>${emp.ename}</td>
						<td>${emp.salary}</td>
						<td>${emp.vaccinated}</td>
				</tr>
				</c:forEach>
			</table>
			</c:when>
			<c:otherwise>
				<h1 style="color:red;text-align:center">Employee not found</h1>
			</c:otherwise>
	</c:choose>


	<h3 style="text-align:center"><a href="./">Main Page</a></h3>&nbsp;&nbsp;
	
	
</body>
</html>



