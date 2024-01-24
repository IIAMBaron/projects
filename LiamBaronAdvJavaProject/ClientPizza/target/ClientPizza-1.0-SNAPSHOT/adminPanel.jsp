<%-- 
    Document   : adminPanel
    Created on : 10 Nov 2023, 20:18:52
    Author     : Baron
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
    </head>
    <body>
        <link rel="stylesheet" href="resources/css/text.css">
    </body>
    <form action="/ClientPizza/admin/logout" method="post">
        <button type="submit" name="logout"  class="right">Log-out</button>
    </form>

    <h1 style="text-align:center">Welcome to the Admin Control Panel:</h1>
    <p style="text-align:center">
        <a href="products">Products</a><br>
        <a href="sales">Sales</a><br>
        <a href="addproduct">Add Product</a><br>
    </p>
</html>
