<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
		<form:form action="/categories/new" method="post" modelAttribute="category">
			 <h2>
			 	<form:label path="name">Name:</form:label>
			 	<form:input path="name"/>
			 </h2>
			 <input type="submit" value="Create"/>
		</form:form>
</body>
</html>