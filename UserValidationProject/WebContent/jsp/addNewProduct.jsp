<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="/UserValidationProject/AddProductServlet" method="post">
Product ID:<br/><input type="text" id="productId" name="productId"/><br/><br/>
Product Name:<br/><input type="text" id="productName" name="productName"/><br/><br/>
Price:<br/><input type="text" id="productPrice" name="productPrice"/><br/><br/>
<input type="submit" value="Add Product"/>
</form>
</center>
</body>
</html>