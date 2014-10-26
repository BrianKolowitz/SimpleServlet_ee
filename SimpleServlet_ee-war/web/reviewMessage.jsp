<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet Review Message</title>
    </head>
    <body>
        <h1>Review Message Pane!</h1>
        <h3><a href ="Message">Click here to got back to the message list</a></h3>
        <form method ="post" action = "Message">
            <input type="hidden" name="id" value="${param["id"]}" />
            <table border="1">
                <tbody>
                    <c:choose>
                    <c:when test="${requestScope.message == null }" >
                        <tr><td>No Message Found</td></tr>
                    </c:when> 
                    <c:otherwise>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="sender" value="${requestScope.message.author}" size="50" /></td>
                        </tr>
                        <tr>
                            <td>Title:</td>
                            <td><input type="text" name="title" value="${requestScope.message.title}" size="50" /></td>
                        </tr>
                        <tr>
                            <td> Message:</td>
                            <td><textarea name="message" rows="4" cols="5">
                                <c:out value="${requestScope.message.message}"></c:out>
                                </textarea>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Save Edited Message" name="Submit" /></td>
                        </tr>
                    </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </form>
    </body>
</html>