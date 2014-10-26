<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message Storage Problem</title>
    </head>
    <body>
        <h1>Hello <c:out value="${requestScope.sender}"></c:out></h1>
        <p>We were unable to store the message:</p>
        <ol>
            <p><c:out value="${requestScope.message}"></c:out></p>
        </ol>
        <a href ="Message">Click here for list</a>
    </body>
</html>