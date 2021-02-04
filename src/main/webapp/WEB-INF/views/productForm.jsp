<%-- 
    Document   : productForm
    Created on : Feb 4, 2021, 10:41:07 AM
    Author     : gkolo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create product</title>
    </head>
    <body>
        <h1>Create your fantastic product</h1>
        <form action="${pageContext.request.contextPath}/product/create" method="POST">
            <label for="pcode">Pcode:</label>
            <input id="pcode" type="number" name="pcode"/>
            <br>
            <label for="pdescr">Description:</label>
            <input id="pdescr" type="text" name="pdescr"/>
            <br>
            <label for="pprice">Price:</label>
            <input id="pprice" type="number" name="pprice" step="0.01"/>
            <br>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
