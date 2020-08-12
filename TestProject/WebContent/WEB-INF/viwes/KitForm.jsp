<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Kit Application</title>
</head>
<body>
    <center>
        <h1>Kit Management</h1>
        <h2>
            <a href="/new">Add New Kit</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Kit</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${kit != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${kit == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
          
                <h2>
                    <c:if test="${kit != null}">
                        Edit Kit
                    </c:if>
                    <c:if test="${kit == null}">
                        Add New Kit
                    </c:if>
                </h2>
            </caption>
                <c:if test="${kit != null}">
                    <input type="hidden" name="id" value="<c:out value='${kit.id}' />" />
                </c:if>           
            <tr>
                <th>PersonName: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${kit.PersonName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${kit.Email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ContactNumber: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${kit.ContactNumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Status: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${kit.Status}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>OrderDate: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${kit.OrderDate}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>