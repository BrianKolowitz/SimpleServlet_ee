<%-- 
    Document   : messageConfirmation
    Created on : Oct 25, 2014, 9:21:33 PM
    Author     : kolowitzbj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message Confirmation</title>
    </head>
    <body>
        <h1>Hello <c:out value="${requestScope.clean_author}"></c:out></h1>
        <p>We stored the following:</p>
        <ol>
            <p><c:out value="${requestScope.clean_title}"></c:out></p>
            <p><c:out value="${requestScope.clean_message}"></c:out></p>
        </ol>
        <h3>Processing time for connection was: <c:out value="${requestScope.connection_time}"></c:out> milliseconds</h3>
        <h3>Processing time for insert was: <c:out value="${requestScope.insert_time}"></c:out> milliseconds</h3>
        <h3>Processing time for close was: <c:out value="${requestScope.close_time}"></c:out> milliseconds</h3>
        <a href ="Message">Click here for list</a>
    </body>
</html>