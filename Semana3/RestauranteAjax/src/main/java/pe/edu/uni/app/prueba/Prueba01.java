package pe.edu.uni.app.prueba;

import pe.edu.uni.app.model.RestauranteModel;
import pe.edu.uni.app.service.RestauranteService;

public class Prueba01 {
	
	public static void main(String[] args) {
		// Datos
		RestauranteModel model = new RestauranteModel();
		model.setPersonas(4);
		model.setDias(10);
		model.setHospedaje(2);
		model.setDesayuno(2);
		model.setAlmuerzo(4);
		model.setCena(1);
		// Procesar
		RestauranteService service = new RestauranteService();
		model = service.procesar(model);
		// Reporte
		System.out.println("Cantidad de personas: " + model.getPersonas());
		System.out.println("Dias de hospedaje: " + model.getDias());
		System.out.println("Tipo de hospedaje: " + model.getStrHospedaje() + "\t" + model.getImpHospedaje());
		System.out.println("Desayumo: " + model.getStrDesayuno() + "\t" + model.getImpDesayuno());
		System.out.println("Almuerzo: " + model.getStrAlmuerzo() + "\t" + model.getImpAlmuerzo());
		System.out.println("Cena: " + model.getStrCena() + "\t" + model.getImpCena());
		System.out.println("Total a pagar: " +  model.getTotal());
	}

}
