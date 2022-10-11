package app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PCC
 */
@WebServlet(name = "SumaServlet", 
        urlPatterns = {"/SumaServlet","/Panchito","/TiaVeneno"})
public class SumaServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        // Datos
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        // Proceso
        int suma = num1 + num2;
        // Reporte
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SUMA</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SUMA</h1>");
            out.println("<p>Número 1: " + num1 + "</p>");
            out.println("<p>Número 2: " + num2 + "</p>");
            out.println("<p>Suma: " + suma + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }    

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      PrintWriter out = response.getWriter();
      out.println("error");
   }


}
