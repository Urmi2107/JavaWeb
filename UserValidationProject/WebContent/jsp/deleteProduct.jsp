<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="/UserValidationProject/ProductDeletionServlet">
        <table border="1" cellpadding="5">
            <caption>List of Products</caption>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Choose to delete</th>
               
            </tr>
            <c:forEach var="product" items="${productPojoList}">
                <tr>
                    <td><c:out value="${product.productId}" /></td>
                    <td><c:out value="${product.productName}" /></td>
                    <td><c:out value="${product.productPrice}" /></td>
                    <td><input type="checkbox" name="checkProduct" value="${product.productId}" /></td>
                </tr>
            </c:forEach>
        </table>
       <br/><input type="submit" value="Delete Product">
        </form>
    </div>
</body>
</html>