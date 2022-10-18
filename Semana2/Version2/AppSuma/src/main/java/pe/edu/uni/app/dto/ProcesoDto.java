package pe.edu.uni.app.dto;

public class ProcesoDto {

	private int numero1;
	private int numero2;
	private int suma;
	private int producto;

	public ProcesoDto() {
		this.numero1 = 0;
		this.numero2 = 0;
		this.suma = 0;
		this.producto = 0;
	}

	public ProcesoDto(int numero1, int numero2, int suma, int producto) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.suma = suma;
		this.producto = producto;
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

}
