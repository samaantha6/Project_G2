package domain;

public class Envio {
	String nReferencia;
	String fecha;
	String precio;
	String descripción;
	String estado;
	String fechaPrevista;
	
	public Envio(String nReferencia, String fecha, String precio, String descripción, String estado,
			String fechaPrevista) {
		this.nReferencia = nReferencia;
		this.fecha = fecha;
		this.precio = precio;
		this.descripción = descripción;
		this.estado = estado;
		this.fechaPrevista = fechaPrevista;
	}
	
	public String getnReferencia() {
		return nReferencia;
	}
	
	public void setnReferencia(String nReferencia) {
		this.nReferencia = nReferencia;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getDescripción() {
		return descripción;
	}
	
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getFechaPrevista() {
		return fechaPrevista;
	}
	
	public void setFechaPrevista(String fechaPrevista) {
		this.fechaPrevista = fechaPrevista;
	}
	
	@Override
	public String toString() {
		return "Envio [nReferencia=" + nReferencia + ", fecha=" + fecha + ", precio=" + precio + ", descripción="
				+ descripción + ", estado=" + estado + ", fechaPrevista=" + fechaPrevista + "]";
	}
	
}

