<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kit Information</title>
</head>
<body>
    <center>
        <h1>Kit Management</h1>
        <h2>
            <a href="kit?action=new">Add New Kit</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Kit</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Kites</h2></caption>
            <tr> 
                <th>ID</th>
                <th>PersonName</th>
                <th>Email</th>
                <th>ContactNumber</th>
                 <th>Status</th>
                  <th>OrderDate</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="kit?action=kit" items="${listKit}">
                <tr>
                    <td><c:out value="${kit.id}" /></td>
                    <td><c:out value="${kit.personName}" /></td>
                    <td><c:out value="${kit.email}" /></td>
                    <td><c:out value="${kit.contactNumber}" /></td>
                    <td><c:out value="${kit.status}" /></td>
                    <td><c:out value="${kit.orderDate}" /></td>
                    <td>
                        <a href="kit?action=edit?id=<c:out value='${kit.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="kit?action=delete?id=<c:out value='${kit.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>