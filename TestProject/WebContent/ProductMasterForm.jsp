<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Application</title>
</head>
<body>
    <center>
        <h1>ProductMaster Management</h1>
        <h2>
            <a href="newProduct">Add New Product</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Product</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${ProductMaster != null}">
            <form action="updateProduct" method="post">
        </c:if>
        <c:if test="${ProductMaster == null}">
            <form action="insertProduct" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
          
                <h2>
                    <c:if test="${ProductMaster != null}">
                        Edit ProductMaster
                    </c:if>
                    <c:if test="${ProductMaster == null}">
                        Add New ProductMaster
                    </c:if>
                </h2>
            </caption>
                <c:if test="${ProductMaster != null}">
                    <input type="hidden" name="id" value="<c:out value='${ProductMaster.id}' />" />
                </c:if>           
            <tr>
                <th>ProductName: </th>
                <td>
                    <input type="text" name="ProductName" size="45"
                            value="<c:out value='${ProductMaster.productName}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Cost: </th>
                <td>
                    <input type="text" name="Cost" size="45"
                            value="<c:out value='${ProductMaster.cost}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ProductDescription: </th>
                <td>
                    <input type="text" name="ProductDescription" size="45"
                            value="<c:out value='${ProductMaster.productDescription}' />"
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