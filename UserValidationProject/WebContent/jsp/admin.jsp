<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<center>
<h3>
<%=session.getAttribute("USER")+" is Admin ." %>
</h3><br/><br/>
<div id="choice">
<a href="jsp/addNewProduct.jsp">Add new product</a><br/>
<a href="/UserValidationProject/ViewProductServlet">View product</a><br/>
<a href="/UserValidationProject/UpdateProductServlet">Update product</a><br/>
<a href="/UserValidationProject/DeleteProductServlet">Remove product</a><br/>
</div>
</center>
</body>
</html>