<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ProductMaster Information</title>
</head>
<body>
    <center>
        <h1>ProductMaster Management</h1>
        <h2>
            <a href="product?action=newProduct">Add New ProductMaster</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All ProductMaster</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of ProductMaster</h2></caption>
            <tr> 
                <th>ID</th>
                <th>ProductName</th>
                <th>Cost</th>
                <th>ProductDescription</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="product" items="${listProductMaster}">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.productName}" /></td>
                    <td><c:out value="${product.cost}" /></td>
                    <td><c:out value="${product.productDescription}" /></td>
                    <td>
                        <a href="product?action=editProduct?id=<c:out value='${product.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="product?action=deleteProduct?id=<c:out value='${product.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>