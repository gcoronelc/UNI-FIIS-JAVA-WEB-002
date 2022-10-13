<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
   int num1 = 0;
   int num2 = 0;
   int suma = 0;
%>
<% 
   if (request.getParameter("btnProcesar") != null) {
      // Datos
      num1 = Integer.parseInt(request.getParameter("num1"));
      num2 = Integer.parseInt(request.getParameter("num2"));
      // Proceso
      suma = num1 + num2;
   }
%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>DEMO SUMA</title>
   </head>
   <body>
      <h1>SUMAR COMO LOS DIOSES</h1>
      <form method="post" action="index.jsp">
         <div>
            <label>Número 1:</label>
            <input type="number" name="num1">
         </div>
         <div>
            <label>Número 2:</label>
            <input type="number" name="num2">
         </div>
         <div><input type="submit" name="btnProcesar" value="Procesar"></div>
      </form>
      
      <%if (request.getParameter("btnProcesar") != null) {%>
      <h1>REPORTE</h1>
      <table border="1">
         <tbody>
            <tr>
               <td>Número 1:</td>
               <td><%=num1%></td>
            </tr>
            <tr>
               <td>Número 2::</td>
               <td><%=num2%></td>
            </tr>
            <tr>
               <%
               Thread.sleep(1000);
               %>
               <td>Suma:</td>
               <td><%=suma%></td>
            </tr>
         </tbody>
      </table>
      <%}%>
   </body>
</html>
