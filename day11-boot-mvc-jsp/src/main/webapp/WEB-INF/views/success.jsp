<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %> 
<!DOCTYPE html> 
<html>  
<head>
<meta charset="ISO-8859-1">
<title>success page</title>
</head>
<body>
 <h1> From success page </h1>
 <h2> List of products </h2>
 <c:forEach var="product" items="${products}">
 		${product}
 </c:forEach>
</body>
</html>

