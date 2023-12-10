package domain;

public class Pago {
	
	String descripcion;
	String numeroTrajeta;
	String fechaCaducidad;
	String CVV;
	String remitenteDestinatario;
	String DNI;
	
	public Pago(String descripcion, String numeroTrajeta, String fechaCaducidad, String CVV,
			String remitenteDestinatario, String DNI) {
		super();
		this.descripcion = descripcion;
		this.numeroTrajeta = numeroTrajeta;
		this.fechaCaducidad = fechaCaducidad;
		this.CVV = CVV;
		this.remitenteDestinatario = remitenteDestinatario;
		this.DNI = DNI;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroTrajeta() {
		return numeroTrajeta;
	}

	public void setNumeroTrajeta(String numeroTrajeta) {
		this.numeroTrajeta = numeroTrajeta;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String CVV) {
		this.CVV = CVV;
	}

	public String getRemitenteDestinatario() {
		return remitenteDestinatario;
	}

	public void setRemitenteDestinatario(String remitenteDestinatario) {
		this.remitenteDestinatario = remitenteDestinatario;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	@Override
	public String toString() {
		return "Pago [descripcion=" + descripcion + ", numeroTrajeta=" + numeroTrajeta + ", fechaCaducidad="
				+ fechaCaducidad + ", CVV=" + CVV + ", remitenteDestinatario=" + remitenteDestinatario + ", DNI=" + DNI
				+ "]";
	}
	
}
