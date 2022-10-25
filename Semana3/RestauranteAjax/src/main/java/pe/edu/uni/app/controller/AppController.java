package pe.edu.uni.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.uni.app.model.ComboModel;
import pe.edu.uni.app.model.RestauranteModel;
import pe.edu.uni.app.service.RestauranteService;

@WebServlet({ "/Procesar", "/traerPrecio", "/traerCombos" })
public class AppController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<ComboModel> tiposHospedaje;
	private List<ComboModel> tiposDesayuno;
	private List<ComboModel> tiposAlmuerzo;
	private List<ComboModel> tiposCena;


	@Override
	public void init() throws ServletException {
	
		// Combo 1: Hospedaje
		tiposHospedaje = new ArrayList<>();
		tiposHospedaje.add(new ComboModel(0, "Seleccionar"));
		tiposHospedaje.add(new ComboModel(1, "Clasico"));
		tiposHospedaje.add(new ComboModel(2, "Ejecutivo"));
		tiposHospedaje.add(new ComboModel(3, "Premium"));
		// Combo 2: Desayuno
		tiposDesayuno = new ArrayList<>();
		tiposDesayuno.add(new ComboModel(0, "Seleccionar"));
		tiposDesayuno.add(new ComboModel(1, "Regional - Básico"));
		tiposDesayuno.add(new ComboModel(2, "Regional - Clasico"));
		tiposDesayuno.add(new ComboModel(3, "Internacional"));
		// Combo 3: Almuerzo
		tiposAlmuerzo = new ArrayList<>();
		tiposAlmuerzo.add(new ComboModel(0, "Seleccionar"));
		tiposAlmuerzo.add(new ComboModel(1, "Regional - Básico"));
		tiposAlmuerzo.add(new ComboModel(2, "Regional - Clasico"));
		tiposAlmuerzo.add(new ComboModel(3, "Internacional"));
		tiposAlmuerzo.add(new ComboModel(4, "De la casa"));
		// Combo 4: Cena
		tiposCena = new ArrayList<>();
		tiposCena.add(new ComboModel(0, "Seleccionar"));
		tiposCena.add(new ComboModel(1, "De la casa"));
		tiposCena.add(new ComboModel(2, "Regional"));
		tiposCena.add(new ComboModel(3, "Internacional"));
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/traerCombos":
			traerCombos(request, response);
			break;
		case "/Procesar":
			procesar(request, response);
			break;
		case "/traerPrecio":
			traerPrecio(request, response);
			break;
		}

	}

	private void traerCombos(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		// Preparando datos
		Map<String, Object> combos =  new  HashMap<>();
		combos.put("hospedaje", tiposHospedaje);
		combos.put("desayuno", tiposDesayuno);
		combos.put("almuerzo", tiposAlmuerzo);
		combos.put("cena", tiposCena);
		Gson gson = new Gson();
		String strJson = gson.toJson(combos);
		// Reporte
		response.setHeader("Content-Type", "application/json");
		PrintWriter writer = response.getWriter();
		writer.write(strJson);
		writer.close();
	}

	private void traerPrecio(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Datos
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int item = Integer.parseInt(request.getParameter("item"));
		// Proceso
		RestauranteService service = new RestauranteService();
		double precio = switch (categoria) {
		case 1 -> service.precioHospedaje(item);
		case 2 -> service.precioDesayuno(item);
		case 3 -> service.precioAlmuerzo(item);
		case 4 -> service.precioCena(item);
		default -> 0.0;
		};
		// Reporte
		String reporte = "Precio: " + precio;
		response.setHeader("Content-Type", "text/plain");
		PrintWriter writer = response.getWriter();
		writer.write(reporte);
		writer.close();
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Variables
		RestauranteModel model = new RestauranteModel();
		// Datos
		model.setPersonas(Integer.parseInt(request.getParameter("personas")));
		model.setDias(Integer.parseInt(request.getParameter("dias")));
		model.setHospedaje(Integer.parseInt(request.getParameter("hospedaje")));
		model.setDesayuno(Integer.parseInt(request.getParameter("desayuno")));
		model.setAlmuerzo(Integer.parseInt(request.getParameter("almuerzo")));
		model.setCena(Integer.parseInt(request.getParameter("cena")));
		// Proceso
		RestauranteService service = new RestauranteService();
		model = service.procesar(model);
		// Reporte
		request.setAttribute("model", model);
		request.setAttribute("control", 2);
		//cargarCombos(request);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("inicio.jsp");
		rd.forward(request, response);
	}

	private void cargarPaginaInicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//cargarCombos(request);
		request.setAttribute("control", 1);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("inicio.jsp");
		rd.forward(request, response);
	}

}
