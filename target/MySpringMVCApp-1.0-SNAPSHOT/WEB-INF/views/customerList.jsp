<%-- 
    Document   : customerList
    Created on : Feb 3, 2021, 8:04:39 PM
    Author     : gkolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
        <style>
            table {
                border: 3px appworkspace solid;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <h1>This is my List with customers</h1>
        <p>
            ${message}
        </p>
        <div>
            <h3>Customers</h3>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfCustomers}" var = "customer">
                        <tr>
                            <td>${customer.ccode}</td>
                            <td>${customer.cname}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/customer/update/${customer.ccode}">Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/customer/delete?id=${customer.ccode}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <br>
            <br>
            <a href="${pageContext.request.contextPath}/customer/create">Add new Customer</a>
        </div>

    </body>
</html>
