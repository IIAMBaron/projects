<%-- 
    Document   : viewCart
    Created on : 07 Nov 2023, 19:09:49
    Author     : Baron
--%>
<%@page import="java.util.Arrays"%>
<%@page import="com.mycompany.clientpizza.viewCartBean"%>
<%@page import="com.mycompany.clientpizza.conversion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>View Cart</title>
    </head>
    <body>
        <form action="/ClientPizza/clearcart" method="get">
            <button type="submit" name="button" >Clear Cart</button>
        </form>
        
        <link rel="stylesheet" href="resources/css/text.css">
        <link rel="stylesheet" href="resources/css/forms.css">
    </body>
    <%

        double total = 0;
        viewCartBean y = new viewCartBean();
        y.setCartBean(session.getAttribute("quantity"), session.getAttribute("prodName"), session.getAttribute("prodPrice"));
        y.setNames();
        y.setPrices();
        y.setQuantity();

        Object[] quantity = y.getQuantity();
        Object[] names = y.getNames();
        Object[] prices = y.getPrices();

        for (int x = 0; x < quantity.length; x++) {
            System.out.println(quantity[x].toString() + prices[x].toString());
            double doubQuan = new Double(quantity[x].toString());
            double doubPrices = new Double(prices[x].toString());
            double cal = doubQuan * doubPrices;
    %><h1><%=quantity[x]%> x <%=names[x]%> = R <%=cal%></h1><%
            total += cal;
        }
    %>

    <h1>TOTAL : R <%=total%></h1>
    <form method="post" action="/ClientPizza/mode">
        <label for="delivery">Delivery(There will be an additional R 1000 added to the final amount)</label>
        <input type="radio" id="delivery" name="mode" value="delivery">
        <label for="collection">Collection</label>
        <input type="radio" id="collection" name="mode" value="collection">
        <input type="submit" value="Submit">
    </form>
    <%
        Object mode = request.getParameter("mode");
        if (mode != null) {

            if (mode.toString().equals("1")) {
    %>
    <h1>Delivery Mode has been selected!</h1>
    <form method="post" action="/ClientPizza/checkout" id="form1">
        <label for="city">City:</label><br>
        <input type="text" id="city" name="city" required><br>
        <label for="suburb">Suburb:</label><br>
        <input type="text" id="suburb" name="suburb" required><br>
        <label for="streetName">Street Name:</label><br>
        <input type="text" id="streetName" name="streetName" required><br>
        <label for="streetNum">Street Number:</label><br>
        <input type="number" id="streetNum" name="streetNum" required><br>
    </form>
    <h2>NEW TOTAL: <%= total + 1000%><br>
        <button type="submit" name="checkout" form="form1" value="delivery">Checkout</button><br>
        <%
            }
            if (mode.toString().equals("0")) {
        %><h1>Collection Mode has been selected!</h1>
        <form action="/ClientPizza/checkout" method="get">
            <button type="submit" name="checkout" value="collection">Checkout</button><br>
        </form>
        <%
                    }
                }%>           
    <div style="position: relative">
        <p style="position: fixed; bottom: 0; width:100%; text-align: center">
            <a href="/ClientPizza">Home</a>
        </p>
    </div>
</html>