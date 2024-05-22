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

	<h1 style="color:red; text-align:center">Passing Model Class Objects Page</h1>

	<c:if test="${!empty empInfo}">
		<b>Emp information:: ${empInfo.eno}, ${empInfo.ename}, ${empInfo.salary}, ${empInfo.vaccinated} </b>
	</c:if>


	<h3 style="text-align:center"><a href="./">Main Page</a></h3>&nbsp;&nbsp;
	
	
</body>
</html>

