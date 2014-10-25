<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet list Messages</title>
    </head>
    <body>
        <h1>The following Messages exist</h1>
        <ol>
            <c:forEach items="${requestScope.messages}" var="message">
                <li><a href="reviewMessage?file=${message.messageid}"><c:out value="${message.author}"></c:out><</a></li>
            </c:forEach>
        </ol>
    </body>
</html>