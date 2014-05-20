<%-- 
    Document   : error
    Created on : 7-mag-2014, 9.13.53
    Author     : confalonieri
--%>

<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Pagina de error</title>
    </head>
    <body bgcolor="FFCCCC">
        <h1>Pagina de error</h1>
        
        <h2>Detalles error</h2>
        <p>Tipo de error:
        <%=exception.getMessage()%>
       
        </p>
         <p>Tipo de error:
        <%=exception.toString()%>
        </p>
        <p>La pagina que ha causado el error:
            <%=request.getAttribute("view")%>    
        </p>
        
        
        
        <h2>Contacta al mail....</h2>
        
        <h2><a href="login.jsp">Volver al principio</a></h2>
    </body>
</html>
