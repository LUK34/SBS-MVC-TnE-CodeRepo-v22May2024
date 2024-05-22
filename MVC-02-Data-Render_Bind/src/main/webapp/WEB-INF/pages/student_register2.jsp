<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expression Language Example</title>
</head>
<body>

<h1 style="color:red; text-align:center">Student Register Form Data Binding Page using spring supplied JSP form tags -> 2 way data binding</h1>


 <%-- <frm:form action="registerStudent2" method="POST" modelAttribute="stud">  --%>
 <%-- <frm:form action="registerStudent2" modelAttribute="stud">  --%>
 <frm:form modelAttribute="stud"> 
    <table align="center" bgcolor="cyan">
        <tr>
            <td>Student Number:</td>
            <td><frm:input path="sno" />   </td>
        </tr>
        
        <tr>
            <td>Student Name:</td>
            <td><frm:input path="sname" />   </td>
        </tr>
        
        <tr>
            <td>Student Address:</td>
            <td><frm:input path="sadd" />   </td>
        </tr>
        
        <tr>
            <td>Student Average:</td>
            <td><frm:input path="avg" />   </td>
        </tr>
    
        <tr style="text-align:center">
            <td colspan="2">
                <input type="submit" value="Register" />
                <input type="reset" value="Cancel" />
            </td>
        </tr>
    </table>
</frm:form>

<h3 style="text-align:center"><a href="./">Main Page</a></h3>&nbsp;&nbsp;

	
</body>
</html>