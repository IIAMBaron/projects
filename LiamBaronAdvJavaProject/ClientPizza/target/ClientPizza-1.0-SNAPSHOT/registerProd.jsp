<%-- 
    Document   : registerProd
    Created on : 14 Nov 2023, 09:36:13
    Author     : EDUV4813733
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <link rel="stylesheet" href="resources/css/text.css">
        <link rel="stylesheet" href="resources/css/forms.css">
    </body>
    <h1 style="text-align: center">Add a product to the website:</h1>
    <form method="GET" action="/ClientPizza/admin/add"  enctype="multipart/form-data" align="center">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"  required><br>
        <label for="price">Price:</label><br>
        <input type="number" id="price" name="price" step=".01" required><br>
        <label for="desc">Product Description:</label><br> 
        <input type="text" id="name" name="desc" required><br>
        <label for="type">Product Type:</label><br> 
        <input type="number" id="type" name="type" min="1" max="2" value="1" required><br><br>
        <input type="submit" value="Add to website">
    </form><br>
    <p style="text-align: center" >
        <a href="/ClientPizza/admin/panel">Back to Admin Panel</a>
    <p>
</html>
