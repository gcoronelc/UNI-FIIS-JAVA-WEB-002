package com.desarrollasoftware.eureka.prueba;

import com.desarrollasoftware.eureka.service.CuentaService;

public class Prueba03 {

	public static void main(String[] args) {
        try {
            CuentaService service = new CuentaService();
            service.procDeposito("00100002", 5000.0, "0002");
            System.out.println("Proceso ok.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
