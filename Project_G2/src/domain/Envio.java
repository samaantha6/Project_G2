package domain;

public class Envio {
	
	Trayecto trayecto;
	Paquete paquete;
	Recogida recogida;
	Pago pago;
	
	public Envio(Trayecto trayecto, Paquete paquete, Recogida recogida, Pago pago) {
		super();
		this.trayecto = trayecto;
		this.paquete = paquete;
		this.recogida = recogida;
		this.pago = pago;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Recogida getRecogida() {
		return recogida;
	}

	public void setRecogida(Recogida recogida) {
		this.recogida = recogida;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "Envio [trayecto=" + trayecto + ", paquete=" + paquete + ", recogida=" + recogida + ", pago=" + pago
				+ "]";
	}
	
}
