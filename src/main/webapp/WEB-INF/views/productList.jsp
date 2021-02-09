<%-- 
    Document   : productList
    Created on : Feb 4, 2021, 10:13:59 AM
    Author     : gkolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "p" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <spring:url value="/resources/css/style.css" var="styleCSS" />
        <link href="${styleCSS}" rel="stylesheet" type="text/css" />
        <title>Product</title>
    </head>
    <body>
        <h1>This is my list of Products</h1>
        <p>
            ${message}
        </p>
        <div>
            <h3>Products</h3>
            <table>
                <thead>
                    <tr>
                        <th>Pcode</th>
                        <th>Pdescr</th>
                        <th>Pprice</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <p:forEach items="${listOfProducts}" var = "product">
                        <tr>
                            <td>${product.pcode}</td>
                            <td>${product.pdescr}</td>
                            <td>${product.pprice}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/product/update/${product.pcode}">Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/product/delete?id=${product.pcode}">Delete</a>
                            </td>
                        </tr>
                    </p:forEach>
                </tbody>
            </table>
            <br>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/product/create">Add new Product</a>
        </div>
    </body>
</html>
