package com.desarrollasoftware.eureka.prueba;

import java.util.List;
import java.util.Map;

import com.desarrollasoftware.eureka.service.ConsultasService;

public class Prueba02 {

	public static void main(String[] args) {
        try {
            ConsultasService service = new ConsultasService();
            List<Map<String,?>> lista = service.consultarResumenOperaciones(300);
            for(Map<String,?> r : lista) {
            	String fila = r.get("SUCURSAL").toString();
            	fila += " - " + r.get("INGRESO").toString();
            	fila += " - " + r.get("SALIDA").toString();
            	System.out.println(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
