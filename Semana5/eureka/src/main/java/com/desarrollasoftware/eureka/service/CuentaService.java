package com.desarrollasoftware.eureka.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.desarrollasoftware.eureka.db.AccesoDB;

public class CuentaService {

	public void procDeposito(String cuenta, double importe, String usuario) {
		Connection cn = null;
		CallableStatement cStmt = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_deposito(?,?,?,?,?)}");
			cStmt.setString(1, cuenta);
			cStmt.setDouble(2, importe);
			cStmt.setString(3, usuario);
			cStmt.registerOutParameter(4, java.sql.Types.INTEGER);
			cStmt.registerOutParameter(5, java.sql.Types.VARCHAR,2000);
			cStmt.execute();
			int estado = cStmt.getInt(4);
			String mensaje = cStmt.getString(5);
			if(estado!=00) {
				throw new SQLException(mensaje);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso.");
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}
	
}
