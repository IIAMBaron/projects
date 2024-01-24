<%-- 
    Document   : viewProducts
    Created on : 10 Nov 2023, 20:22:04
    Author     : Baron
--%>
<%@page import="com.mycompany.clientpizza.conversion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Products</title>
    </head>
    <body>
        <h1>Products Table:</h1>
        <style>
        table, th, td {
        border:1px solid black;
        }
        </style>
        <table>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Product Description</th>
                <th>Image Location</th>
                <th>Type</th>
            </tr>
            
                <% 
                    conversion c = new conversion();
                    try { 
                        pizzalore.DatabaseWebService_Service service = new pizzalore.DatabaseWebService_Service();
                        pizzalore.DatabaseWebService port = service.getDatabaseWebServicePort();

                        List<String> result = port.products();
                        for (Object name : result) {
                            c.setConversion(name);
                            
                            Object[] actualName = c.getNames();
                            %>
                            <tr>
                                <td><%=actualName[0]%></td>
                                <td><%=actualName[1]%></td>
                                <td><%=actualName[2]%></td>
                                <td><%=actualName[3]%></td>
                                <td><%=actualName[4]%></td>
                                <td><%=actualName[5]%></td>
                            </tr>
                            <%    
                        }
                } catch (Exception ex) {
            // TODO handle custom exceptions here
                }
            %>
            
        </table><br>
            <a href="/ClientPizza/admin/panel">Back to Admin Panel</a>
    </body>
</html>
