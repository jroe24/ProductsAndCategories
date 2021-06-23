<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Product Page</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<h2>Categories:</h2>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<li><h2><c:out value="${category.name}"/></h2></li>
			</c:forEach>
		</ul>
	<c:if test="${!empty categories}">
		<h2>Add a Product</h2>
			<form action="/products/${product.id}" method="post">
				<label for="product">Add Category:</label>
				<select name="product">
					<c:forEach items="${categories}" var="product">
			        	<option value="${category.id}"><c:out value="${category.name}"/></option>
			   		</c:forEach>
				</select>
				<input type="submit" value="Add"/>
			</form>
	</c:if>
</body>
</html>