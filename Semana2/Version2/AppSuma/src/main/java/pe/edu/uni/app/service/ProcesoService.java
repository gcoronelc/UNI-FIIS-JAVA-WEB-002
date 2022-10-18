package pe.edu.uni.app.service;

import pe.edu.uni.app.dto.ProcesoDto;

public class ProcesoService {

	
	public ProcesoDto procesar(ProcesoDto dto) {
		dto.setSuma(dto.getNumero1() + dto.getNumero2());
		dto.setProducto(dto.getNumero1() * dto.getNumero2());
		return dto;
	}
	
}
