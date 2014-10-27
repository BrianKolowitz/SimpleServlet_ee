<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Message</title>
    </head>
    <body>
        <h1>Submit Message Page</h1>
        <form method ="post" action = "Message">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="sender" value="" size="50" /></td>
                    </tr>
                     <tr>
                        <td>Title:</td>
                        <td><input type="text" name="title" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td> Message:</td>
                        <td><textarea name="message" rows="8" cols="50"></textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit" name="Submit" /></td>
                    </tr>
                </tbody>
            </table>
        </form>  
        <br />
        <a href="Message">Click here for list of Messages</a>
    </body>
</html>
