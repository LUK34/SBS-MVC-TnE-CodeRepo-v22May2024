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
    <h1 style="color:red; text-align:center">JSTL Page-> Model attribute data are:</h1>
    
    <p style="text-align:center">
    
    <b>fav colors are:: </b><br>
    <c:forEach var="color" items="${favColors}">
        ${color}<br>
    </c:forEach>
    
    <br>
    
    <b>NickNames are:: </b>
    <c:forEach var="name" items="${nickNames}">
        ${name}<br>
    </c:forEach>
    
    <br>
    
    <b>PhoneNumbers are::</b> <br>
    <c:forEach var="ph" items="${phoneNumbers}">
        ${ph}<br>
    </c:forEach>
    
    <br>
    
    <b>idDetails are::</b> <br>
    <c:forEach var="id" items="${idDetails}">
        ${id.key}, ${id.value}<br>
    </c:forEach>
    
    </p>
    
    <h3 style="text-align:center"><a href="./">Main Page</a></h3>&nbsp;&nbsp;
    
    
</body>
</html>
