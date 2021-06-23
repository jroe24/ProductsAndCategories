<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
		<form:form action="/products/new" method="post" modelAttribute="product">	  
			<h2>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
			</h2>
	   		<h2>
				<form:label path="description">Description:</form:label>
				<form:textarea path="description"/>
			</h2>
	   		<h2>
				<form:label path="price">Price:</form:label>
				<form:input path="price"/>
			</h2>
			<input type="submit" value="Create"/>	 
		</form:form>
</body>
</html>