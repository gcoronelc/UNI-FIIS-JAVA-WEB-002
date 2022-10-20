package pe.edu.uni.app.model;

public class RestauranteModel {

	// Datos de entrada
	private int personas;
	private int dias;
	private int hospedaje;
	private int desayuno;
	private int almuerzo;
	private int cena;
	// datos de salida
	private double impHospedaje;
	private String strHospedaje;
	private double impDesayuno;
	private String strDesayuno;
	private double impoAlmuerzo;
	private String strAlmuerzo;
	private double impCena;
	private String strCena;
	
	public RestauranteModel() {
	}

	public RestauranteModel(int personas, int dias, int hospedaje, int desayuno, int almuerzo, int cena) {
		super();
		this.personas = personas;
		this.dias = dias;
		this.hospedaje = hospedaje;
		this.desayuno = desayuno;
		this.almuerzo = almuerzo;
		this.cena = cena;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getHospedaje() {
		return hospedaje;
	}

	public void setHospedaje(int hospedaje) {
		this.hospedaje = hospedaje;
	}

	public int getDesayuno() {
		return desayuno;
	}

	public void setDesayuno(int desayuno) {
		this.desayuno = desayuno;
	}

	public int getAlmuerzo() {
		return almuerzo;
	}

	public void setAlmuerzo(int almuerzo) {
		this.almuerzo = almuerzo;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public double getImpHospedaje() {
		return impHospedaje;
	}

	public void setImpHospedaje(double impHospedaje) {
		this.impHospedaje = impHospedaje;
	}

	public String getStrHospedaje() {
		return strHospedaje;
	}

	public void setStrHospedaje(String strHospedaje) {
		this.strHospedaje = strHospedaje;
	}

	public double getImpDesayuno() {
		return impDesayuno;
	}

	public void setImpDesayuno(double impDesayuno) {
		this.impDesayuno = impDesayuno;
	}

	public String getStrDesayuno() {
		return strDesayuno;
	}

	public void setStrDesayuno(String strDesayuno) {
		this.strDesayuno = strDesayuno;
	}

	public double getImpoAlmuerzo() {
		return impoAlmuerzo;
	}

	public void setImpoAlmuerzo(double impoAlmuerzo) {
		this.impoAlmuerzo = impoAlmuerzo;
	}

	public String getStrAlmuerzo() {
		return strAlmuerzo;
	}

	public void setStrAlmuerzo(String strAlmuerzo) {
		this.strAlmuerzo = strAlmuerzo;
	}

	public double getImpCena() {
		return impCena;
	}

	public void setImpCena(double impCena) {
		this.impCena = impCena;
	}

	public String getStrCena() {
		return strCena;
	}

	public void setStrCena(String strCena) {
		this.strCena = strCena;
	}
	
	
}
