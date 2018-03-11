<%-- 
    Document   : index
    Created on : Mar 9, 2018, 2:25:39 PM
    Author     : USER
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
        <h1>Colors!</h1>
        <c:forEach var="color" items="${colors}">
            <h2>${color.name}</h2>
        </c:forEach>
    </body>
</html>
