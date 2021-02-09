<%-- 
    Document   : salesmanList
    Created on : Feb 3, 2021, 8:04:39 PM
    Author     : gkolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman</title>
        <style>
            table {
                border: 3px appworkspace solid;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <h1>This is my List with salesmen</h1>
        <p>
            ${message}
        </p>
        <div>
            <h3>Salesmen</h3>
            <table>
                <thead>
                    <tr>
                        <th>Code</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Commission</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfSalesmen}" var = "salesman">
                        <tr>
                            <td>${salesman.scode}</td>
                            <td>${salesman.sname}</td>
                            <td>${salesman.scity}</td>
                            <td>${salesman.scomm}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/salesman/update/${salesman.scode}">Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/salesman/delete?id=${salesman.scode}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}/salesman/create">Add new Salesman</a>
        </div>

    </body>
</html>
