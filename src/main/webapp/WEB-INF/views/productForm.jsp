<%-- 
    Document   : productForm
    Created on : Feb 4, 2021, 10:41:07 AM
    Author     : gkolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "p" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create product</title>
    </head>
    <body>
        <h1>Create your fantastic product</h1>
        <p:if test="${productToEdit == null}">
            <p:url value="/product/create" var="link"/>
        </p:if>
        <p:if test="${productToEdit != null}">
            <p:url value="/product/update" var="link"/>
        </p:if>
        <form action="${link}" method="POST">
            <label for="pcode">Pcode:</label>
            <input id="pcode" type="number" name="pcode" value="${productToEdit.pcode}" readonly/>
            <br>
            <label for="pdescr">Description:</label>
            <input id="pdescr" type="text" name="pdescr" value="${productToEdit.pdescr}"/>
            <br>
            <label for="pprice">Price:</label>
            <input id="pprice" type="number" name="pprice" step="0.01" value="${productToEdit.pprice}"/>
            <br>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
