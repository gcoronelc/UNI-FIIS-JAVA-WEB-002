package com.desarrollasoftware.eureka.prueba;

import java.sql.Connection;

import com.desarrollasoftware.eureka.db.AccesoDB;


public class Prueba01 {
    
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion ok.");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
