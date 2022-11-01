package com.desarrollasoftware.eureka.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.desarrollasoftware.eureka.db.AccesoDB;

public class ConsultasService {

	public List<Map<String, ?>> consultarResumenOperaciones(int dias) {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_resumen_operaciones(?)}");
			cStmt.setInt(1, dias);
			cStmt.execute();
			rs = cStmt.getResultSet();
			lista = JdbcUtil.rsToList(rs);
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
		return lista;
	}

}
