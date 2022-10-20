package pe.edu.uni.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.uni.app.model.ComboModel;
import pe.edu.uni.app.model.RestauranteModel;
import pe.edu.uni.app.service.RestauranteService;

@WebServlet({ "/", "/home", "/Procesar" })
public class AppController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/home":
		case "/":
			cargarPaginaInicio(request, response);
			break;
		case "/Procesar":
			procesar(request, response);
			break;
		}

	}

	private void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Variables
		RestauranteModel model = new RestauranteModel();
		// Datos
		model.setPersonas(Integer.parseInt(request.getParameter("personas")));

		// Proceso
		RestauranteService service = new RestauranteService();
		model = service.procesar(model);
		// Reporte
		request.setAttribute("model", model);
		cargarCombos(request);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("inicio.jsp");
		rd.forward(request, response);
	}

	private void cargarPaginaInicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cargarCombos(request);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("inicio.jsp");
		rd.forward(request, response);
	}

	private void cargarCombos(HttpServletRequest request) {
		// Combo 1: Hospedaje
		List<ComboModel> hospedaje = new ArrayList();
		hospedaje.add(new ComboModel(1, "Clasico"));
		hospedaje.add(new ComboModel(2, "Ejecutivo"));
		hospedaje.add(new ComboModel(3, "Premium"));
		request.setAttribute("hospedaje", hospedaje);
		// Combo 2: Desayuno
		List<ComboModel> desayuno = new ArrayList();
		desayuno.add(new ComboModel(1, "Regional - Básico"));
		desayuno.add(new ComboModel(2, "Regional - Clasico"));
		desayuno.add(new ComboModel(3, "Internacional"));
		request.setAttribute("desayuno", desayuno);
		// Combo 3: Almuerzo
		List<ComboModel> almuerzo = new ArrayList();
		almuerzo.add(new ComboModel(1, "Regional - Básico"));
		almuerzo.add(new ComboModel(2, "Regional - Clasico"));
		almuerzo.add(new ComboModel(3, "Internacional"));
		almuerzo.add(new ComboModel(4, "De la casa"));
		request.setAttribute("almuerzo", almuerzo);
		// Combo 4: Cena
		List<ComboModel> cena = new ArrayList();
		cena.add(new ComboModel(1, "De la casa"));
		cena.add(new ComboModel(2, "Regional"));
		cena.add(new ComboModel(3, "Internacional"));
		request.setAttribute("cena", cena);
	}

}
