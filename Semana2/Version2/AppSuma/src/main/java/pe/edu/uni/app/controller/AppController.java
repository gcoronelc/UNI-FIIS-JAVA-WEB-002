package pe.edu.uni.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.uni.app.dto.ProcesoDto;

@WebServlet({ "/Procesar1", "/Procesar2" })
public class AppController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/Procesar1":
			procesar1(request, response);
			break;
		case "/Procesar2":
			procesar2(request, response);
			break;
		}

	}

	private void procesar2(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		// Variables
		ProcesoDto dto = new ProcesoDto();
		// Datos
		dto.setNumero1(Integer.parseInt(request.getParameter("numero1")));
		dto.setNumero2(Integer.parseInt(request.getParameter("numero2")));
		// Proceso
		dto.setSuma(dto.getNumero1() + dto.getNumero2());
		dto.setProducto(dto.getNumero1() * dto.getNumero2());
		// Reporte
		Gson gson = new Gson();
		String jsonString = gson.toJson(dto);
		//response.setHeader("Content-Type", "text/plain");
		response.setHeader("Content-Type", "application/json");
	    PrintWriter writer = response.getWriter();
	    writer.write(jsonString);
	    writer.close();
	}

	private void procesar1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Variables
		ProcesoDto dto = new ProcesoDto();
		// Datos
		dto.setNumero1(Integer.parseInt(request.getParameter("numero1")));
		dto.setNumero2(Integer.parseInt(request.getParameter("numero2")));
		// Proceso
		dto.setSuma(dto.getNumero1() + dto.getNumero2());
		dto.setProducto(dto.getNumero1() * dto.getNumero2());
		// Reporte
		request.setAttribute("dto", dto);
		RequestDispatcher rd = request.getRequestDispatcher("ejemplo1B.jsp");
		rd.forward(request, response);
	}

}
