package domain;

public class Recogida {

	String fechaDeEnvio;
	String lugarDeRecogida;
	String tipoDeEnvio;
	
	public Recogida(String fechaDeEnvio, String lugarDeRecogida, String tipoDeEnvio) {
		this.fechaDeEnvio = fechaDeEnvio;
		this.lugarDeRecogida = lugarDeRecogida;
		this.tipoDeEnvio = tipoDeEnvio;
	}

	public String getFechaDeEnvio() {
		return fechaDeEnvio;
	}

	public void setFechaDeEnvio(String fechaDeEnvio) {
		this.fechaDeEnvio = fechaDeEnvio;
	}

	public String getLugarDeRecogida() {
		return lugarDeRecogida;
	}

	public void setLugarDeRecogida(String lugarDeRecogida) {
		this.lugarDeRecogida = lugarDeRecogida;
	}

	public String getTipoDeEnvio() {
		return tipoDeEnvio;
	}

	public void setTipoDeEnvio(String tipoDeEnvio) {
		this.tipoDeEnvio = tipoDeEnvio;
	}

	@Override
	public String toString() {
		return "Recogida [fechaDeEnvio=" + fechaDeEnvio + ", lugarDeRecogida=" + lugarDeRecogida + ", tipoDeEnvio="
				+ tipoDeEnvio + "]";
	}
	
}
