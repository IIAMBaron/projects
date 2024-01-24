<%-- 
    Document   : adminImage
    Created on : 17 Nov 2023, 13:51:30
    Author     : EDUV4813733
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Image</title>
    </head>
    <h1 style="text-align: center">Image Uploader:</h1>
    <body>
        <link rel="stylesheet" href="resources/css/text.css">
        <link rel="stylesheet" href="resources/css/forms.css">
        <form align="center" method="post" action="/ClientPizza/admin/add"  enctype="multipart/form-data">
        <label for="image">Image:</label><br>
        <input type="file" id="image" name="image" accept="image/*" required><br><br>
            <input type="submit" value="Add to website">
        </form><br>
    </body>
    <p style="text-align: center" >
        <a href="/ClientPizza/admin/panel">Back to Admin Panel</a>
    <p>
</html>
