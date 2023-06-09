<%-- 
    Document   : listproduct
    Created on : Jun 9, 2023, 9:52:51 PM
    Author     : leede
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Description</th>
                <th>Original Price</th>
                <th>Sell Price</th>
                <th>Amount</th>
                <th>Image Link</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${sessionScope.listP}" var="product">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>
                    <c:forEach items="${sessionScope.listCate}" var="c">
                        ${c.categoryname}
                    </c:forEach>
                </td>
                <td>${product.description}</td>
                <td>${product.originalPrice}</td>
                <td>${product.sellPrice}</td>
                <td>${product.amount}</td>
                <td>${product.imgLink}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>
