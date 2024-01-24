<%-- 
    Document   : adminLogin
    Created on : 24 Oct 2023, 08:50:56
    Author     : EDUV4813733
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log-in</title>
    </head>
    <body>
        <link rel="stylesheet" href="resources/css/text.css">
        <link rel="stylesheet" href="resources/css/forms.css">
        <h3>Login</h3>
        <form method="post" action="/ClientPizza/validateLogin">
            <label for="username">Username:</label><br>
            <input type="text" id="username" name="username" ><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password"><br>
            <input type="submit" value="Submit" >
        </form>
        <p style="color:red"><%
                String result = request.getParameter("response");
                System.out.println(result);
                if (result != null) {
                    if (result.equals("False")) {
                        out.println("Login Failed");
                    }
                }
            
            %>
    </body>
</html>
