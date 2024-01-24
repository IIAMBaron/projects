<%-- 
    Document   : checkOut
    Created on : 13 Nov 2023, 12:47:37
    Author     : EDUV4813733
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CheckOut</title>
    </head>
    <body>
        <link rel="stylesheet" href="resources/css/text.css">
        <h1>This is your unique Order ID that can be used to show proof of payment:</h1>
        <% Object orderID = session.getAttribute("orderID");
        %>
        <h1><%=orderID%></h1>
        <div style="position: relative">
        <p style="position: fixed; bottom: 0; width:100%; text-align: center">
            <a href="/ClientPizza">Home</a>
        </p>
    </div>
    </body>
</html>
