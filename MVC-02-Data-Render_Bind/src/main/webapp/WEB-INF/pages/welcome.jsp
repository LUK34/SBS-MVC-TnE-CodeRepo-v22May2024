<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expression Language Example</title>
</head>
<body>


	<h1 style="color:red; text-align:center">Welcome to Spring Boot MVC -> welcome.jsp Page</h1>
	<h3 style="text-align:center"><a href="age">age.jsp</a></h3>&nbsp;&nbsp;
	<h3 style="text-align:center"><a href="details">details.jsp</a></h3>&nbsp;&nbsp;
	<h3 style="color:green; text-align:center"><a href="season">Season.jsp</a></h3>&nbsp;&nbsp;
	<h3 style="color:green; text-align:center"><a href="showJstl">show_jstl.jsp</a></h3>&nbsp;&nbsp;
	
	<h3 style="color:green; text-align:center">
		<a href="passingModelClassObject">
			pass_model_class_object.jsp
		</a>
	</h3>&nbsp;&nbsp;
	
	<h3 style="color:green; text-align:center">
		<a href="passingCollectionOfModelClassObject">
			pass_collection_model_class_object.jsp
		</a>
	</h3>&nbsp;&nbsp;
	
	<h3 style="color:green; text-align:center">
			<a href="registerStudent">
					Passing Form data to Controller class handler method as Model Class Object
			</a>
	</h3>
	
	
		<h3 style="color:green; text-align:center">
			<a href="registerStudent2">
					Passing Form data using Spring MVC supplied JSP Form Tags-> 2 way data binding
			</a>
	</h3>
	
	
</body>
</html>