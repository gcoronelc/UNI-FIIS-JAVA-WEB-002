<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   // Variables
   String[] nombres = null;
   String[] notas = null;
   // Datos
   if(request.getParameter("btnProcesar")!=null){
      nombres = request.getParameterValues("nombre");
      notas = request.getParameterValues("nota");
   }

%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>PASAR ARREGLO</title>
   </head>
   <body>
      <h1>PASAR ARREGLO</h1>
      <form method="post" action="pasarArreglo.jsp">
         
         <table border="1">
            <thead>
               <tr>
                  <th>ESTUDIANTE</th>
                  <th>NOTA</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td><input type="text" name="nombre" /></td>
                  <td><input type="number" name="nota" /></td>
               </tr>
               <tr>
                  <td><input type="text" name="nombre" /></td>
                  <td><input type="number" name="nota" /></td>
               </tr>
               <tr>
                  <td><input type="text" name="nombre" /></td>
                  <td><input type="number" name="nota" /></td>
               </tr>
               <tr>
                  <td><input type="text" name="nombre" /></td>
                  <td><input type="number" name="nota" /></td>
               </tr>
               <tr>
                  <td><input type="text" name="nombre" /></td>
                  <td><input type="number" name="nota" /></td>
               </tr>
            </tbody>
         </table>     
         <input type="submit" name="btnProcesar" value="Procesar" />
      </form>
      
      <%if(request.getParameter("btnProcesar")!=null){%>
         <h1>DATOS INGRESADOS</h1>
         <%
            int i = 0;
            for (String nombre : nombres) {
                  out.print("<p>" + nombre + " - " + notas[i] + "</p>");
                  i++;
            }
         %>
      <%}%>
   </body>
</html>
