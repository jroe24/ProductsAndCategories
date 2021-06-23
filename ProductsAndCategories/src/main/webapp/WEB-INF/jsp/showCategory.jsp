<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Category Page</title>
</head>
<body>
	<h1><c:out value="${category.name}"/></h1>
	<h2>Products:</h2>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li><h2><c:out value="${product.name}"/></h2></li>
			</c:forEach>
		</ul>
	<c:if test="${!empty products}">
		<h2>Add a Product</h2>
			<form action="/categories/${category.id}" method="post">
				<label for="product">Add Product:</label>
				<select name="product">
					<c:forEach items="${products}" var="product">
			        	<option value="${product.id}"><c:out value="${ product.name }"/></option>
			   		</c:forEach>
				</select>
				<input type="submit" value="Add"/>
			</form>
	</c:if>
</body>
</html>