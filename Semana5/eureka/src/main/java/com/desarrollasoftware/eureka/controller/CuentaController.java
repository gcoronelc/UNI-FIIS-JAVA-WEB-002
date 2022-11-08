package com.desarrollasoftware.eureka.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desarrollasoftware.eureka.model.Mensaje;
import com.desarrollasoftware.eureka.service.CuentaService;
import com.google.gson.Gson;

/**
 * Servlet implementation class CuentaController
 */
@WebServlet({"/CuentaController","/postProcesarDeposito"})
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/postProcesarDeposito":
			postProcesarDeposito(request, response);
			break;

		default:
			break;
		}
	}

	private void postProcesarDeposito(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Mensaje msg = new Mensaje();
		try {
			// Datos
			String cuenta = request.getParameter("cuenta");
			double importe = Double.parseDouble(request.getParameter("importe"));
			// Proceso
			CuentaService service = new CuentaService();
			service.procDeposito(cuenta, importe, "0002");
			msg.setEstado(1);
			msg.setMensaje("Proceso ejecutado correctamente");
		} catch (Exception e) {
			msg.setEstado(-1);
			msg.setMensaje(e.getMessage());
		}
		// Reporte
		Gson gson = new Gson();
		String strJson = gson.toJson(msg);
		HttpUtil.reporteJson(response, strJson);
	}

}
