<%-- 
    Document   : salesmanFamilyList
    Created on : Feb 10, 2021, 2:17:58 PM
    Author     : gkolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Family</title>
    </head>
    <body>
        <h1>This is family</h1>
        <div>
            <h3>Salesmen family</h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>Fid</th>
                        <th>FName</th>
                        <th>Relationship</th>
                        <th>Date of Birth</th>  
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOfFamilies}" var = "families">
                        <tr>
                            <td>${families.fid}</td>
                            <td>${families.fname}</td>
                            <td>${families.frelationship}</td>
                            <td>${families.dob}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/family/update/${families.fid}">Edit</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/family/delete?id=${families.fid}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}/family/create">Add new Family</a>
        </div>
    </body>
</html>
