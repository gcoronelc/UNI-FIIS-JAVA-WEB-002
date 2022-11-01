package com.desarrollasoftware.eureka.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desarrollasoftware.eureka.service.ConsultasService;
import com.google.gson.Gson;


@WebServlet({"/ConResumen1"})
public class ConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/ConResumen1":
			getConResumen1(request, response);
			break;

		default:
			break;
		}
	}

	private void getConResumen1(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		// Parametro
		int dias = Integer.parseInt(request.getParameter("dias"));
		// Proceso
		ConsultasService service = new ConsultasService();
		List<Map<String,?>> lista = service.consultarResumenOperaciones(dias);
		// Reporte
		Gson gson = new Gson();
		String strJson = gson.toJson(lista);
		HttpUtil.reporteJson(response, strJson);
	}

}
