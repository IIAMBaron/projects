<%-- 
    Document   : ShoppingCart
    Created on : 30 Oct 2023, 09:05:59
    Author     : EDUV4813733
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <link rel="stylesheet" href="resources/css/text.css">
        <link rel="stylesheet" href="resources/css/forms.css">
    </body>
    
    <div class="form-container">
        <form method="post" action="shoppingcart" >
            <label for="quantity">Select quantity:</label>
            <input type="number" id="quantity" name="quantity" value="1" min="1" max="10">
            <input type="submit" value="Add to Cart">
        </form>
    </div>
</html>
