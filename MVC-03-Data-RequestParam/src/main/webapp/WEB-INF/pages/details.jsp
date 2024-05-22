<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expression Language Example</title>
</head>
<body>
	  <h1 style="color:red; text-align:center">Welcome to Spring Boot MVC -> details.jsp Page</h1>
    <h3 style="text-align:center">
     
        <b> Model attribute data is </b> <br>
     
        <b>Fav colors are: 
            <%
	                String[] favColors = (String[]) request.getAttribute("favColors");
	                if (favColors != null)
	                 {
	                    out.print(Arrays.toString(favColors));
	                }
	                 else 
	                {
	                    out.print("No favorite colors provided");
	                }
            %>
        </b> <br>
     
        <b> Nick names are: ${nickNames} </b> <br>
        <b> Phone Numbers are: ${phoneNumbers} </b> <br>
        <b> idDetails are: ${idDetails} </b> <br>
   
    </h3>
    
    <h3 style="text-align:center"><a href="./">Main Page</a></h3>
</body>
</html>