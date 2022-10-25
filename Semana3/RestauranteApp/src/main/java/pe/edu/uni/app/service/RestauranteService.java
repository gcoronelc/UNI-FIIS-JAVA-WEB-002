package pe.edu.uni.app.service;

import pe.edu.uni.app.model.RestauranteModel;

public class RestauranteService {

	public RestauranteModel procesar(RestauranteModel model) {
		// Datos
		int personas = model.getPersonas();
		int dias = model.getDias();
		int hospedaje = model.getHospedaje();
		int desayuno = model.getDesayuno();
		int almuerzo = model.getAlmuerzo();
		int cena = model.getCena();
		// Proceso
		double impHospedaje = personas * dias * precioHospedaje(hospedaje);
		double impDesayuno = personas * dias * precioDesayuno(desayuno);
		double impoAlmuerzo = personas * dias * precioAlmuerzo(almuerzo);
		double impCena = personas * dias * precioCena(cena);
		double total = impHospedaje + impDesayuno + impoAlmuerzo + impCena;
		model.setStrHospedaje(nombHospdaje(hospedaje));
		model.setStrDesayuno(nombDesayuno(desayuno));
		model.setStrAlmuerzo(nombAlmuerzo(almuerzo));
		model.setStrCena(nombCena(cena));
		// Reporte
		model.setImpHospedaje(impHospedaje);
		model.setImpDesayuno(impDesayuno);
		model.setImpAlmuerzo(impoAlmuerzo);
		model.setImpCena(impCena);
		model.setTotal(total);
		return model;
	}

	private String nombCena(int cena) {
		return switch (cena) {
		case 1 -> "De la casa";
		case 2 -> "Regional";
		case 3 -> "Internacional";
		default -> "";
		};
	}

	private String nombAlmuerzo(int almuerzo) {
		return switch (almuerzo) {
		case 1 -> "Regional - Básico";
		case 2 -> "Regional - Clásico";
		case 3 -> "Internacional";
		case 4 -> "De la casa";
		default -> "";
		};
	}

	private String nombDesayuno(int desayuno) {
		return switch (desayuno) {
		case 1 -> "Regional - Básico";
		case 2 -> "Regional - Clásico";
		case 3 -> "Internacional";
		default -> "";
		};
	}

	private String nombHospdaje(int hospedaje) {
		return switch (hospedaje) {
		case 1 -> "Clásico";
		case 2 -> "Ejecutivo";
		case 3 -> "Premium";
		default -> "";
		};
	}

	private double precioCena(int cena) {
		return switch (cena) {
		case 1 -> 20.0;
		case 2 -> 25.0;
		case 3 -> 30.0;
		default -> 0.0;
		};
	}

	private double precioAlmuerzo(int almuerzo) {
		return switch (almuerzo) {
		case 1 -> 15.0;
		case 2 -> 25.0;
		case 3 -> 35.0;
		case 4 -> 30.0;
		default -> 0.0;
		};
	}

	private double precioDesayuno(int desayuno) {
		return switch (desayuno) {
		case 1 -> 5.0;
		case 2 -> 8.0;
		case 3 -> 10.0;
		default -> 0.0;
		};
	}

	public double precioHospedaje(int hospedaje) {
		return switch (hospedaje) {
		case 1 -> 80.0;
		case 2 -> 120.0;
		case 3 -> 160.0;
		default -> 0.0;
		};
	}

}
