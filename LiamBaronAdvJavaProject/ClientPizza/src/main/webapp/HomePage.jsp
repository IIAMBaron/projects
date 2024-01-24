<%-- 
    Document   : HomePage
    Created on : 31 Oct 2023, 15:37:45
    Author     : EDUV4813733
--%>
<%@ page language="java" errorPage="error.jsp"%>
<%@page import="com.mycompany.clientpizza.conversion"%>
<%@page import="pizzalore.HomePage"%>
<%@page import="com.mycompany.clientpizza.productsBean"%>
<%@page import="pizzalore.DatabaseWebService_Service"%>
<%@page import="pizzalore.DatabaseWebService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Store</title>
        <link rel="stylesheet" href="resources/css/images.css">
        <link rel="stylesheet" href="resources/css/text.css">
    </head>
    <body>
        <h1>PIZZA STORE</h1>
        <a href="shoppingcart">Shopping Cart</a>
        <form method="post" action="/ClientPizza/homePage"
          <label for="foods">Filter:</label>
        <select name="foods" id="foods">
            <option value="all">All</option>
            <%
            request.getSession(true);
            
        try {
            int x = 0;
            pizzalore.DatabaseWebService_Service service = new pizzalore.DatabaseWebService_Service();
            pizzalore.DatabaseWebService port = service.getDatabaseWebServicePort();
            
            List<String> result = port.prodTypes();
            for (String name:result) {
                x++;
                System.out.println(x + name);
            %><option value=<%=x%>><%=name%></option><%
            }
        } catch(Exception e) {}
            %>
            <input type="submit" value="Submit"><br>
            <% 
                String result = request.getParameter("filter");
                try {
                    conversion c = new conversion();
                    if (result == null ) {
                        result = "all";
                    }
                        pizzalore.DatabaseWebService_Service service = new pizzalore.DatabaseWebService_Service();
                        DatabaseWebService port = service.getDatabaseWebServicePort();
                        List<String> prod = port.homePage(result);
                        List<Object> products = new ArrayList<Object>(prod);


                        for (Object name: products) {
                            c.setConversion(name);
                            Object[] actualName = c.getNames();
                            productsBean z = new productsBean(actualName);
                            
                            %>
                            <img src="<%=z.getProdImage()%>" class="center">
                            <p>
                            <h1><%=z.getProdName()%></h1>
                            <h1><%=z.getProdDesc()%></h1>
                            <h1>R <%=z.getProdPrice()%></h1>
                            </p>
                            <button type="submit" formaction="/ClientPizza/quantity" name="button" value="<%=z.getProdName()+ ","+z.getProdPrice() + "," + z.getProdID() %>" method="get" >Order Now</button><br><br><%
                            
                    }
                }catch(Exception e)
                    {System.out.println(e.getMessage());}
            %>
    </body>
</html>
