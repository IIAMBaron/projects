<%-- 
    Document   : error
    Created on : 22 Nov 2023, 09:32:44
    Author     : Baron
--%>

<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
</head>
<body>
<% if(response.getStatus() == 500){ %>
<font color="red">Error: <%=exception.getMessage() %></font><br>


<%}else {%>
Hi There, error code is <%=response.getStatus() %><br>
Please go to <a href="/ClientPizza">Home</a>
<%} System.out.println("an error has occured");%>
</body>
</html>
