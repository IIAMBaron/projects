<%-- 
    Document   : sales
    Created on : 10 Nov 2023, 20:22:29
    Author     : Baron
--%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.clientpizza.conversion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales</title>
    </head>
    <body>
        <h1>Sales Report:</h1>
        <style>
        table, th, td {
        border:1px solid black;
        }
        </style>
        <table>
            <th>Name</th>
            <th>Quantity</th>
            <th>Totals</th>
            <%
              conversion c = new conversion();
                    try { 
                        pizzalore.DatabaseWebService_Service service = new pizzalore.DatabaseWebService_Service();
                        pizzalore.DatabaseWebService port = service.getDatabaseWebServicePort();

                        List<String> result = port.sales();
                        for (Object name : result) {
                            c.setConversion(name);
                            
                            Object[] actualName = c.getNames();
                            %>
                            <tr>
                                <td><%=actualName[0]%></td>
                                <td><%=actualName[1]%></td>
                                <td>R <%=actualName[2]%></td>
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
