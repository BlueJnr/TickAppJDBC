package edu.calidadsw.model.json;

public class Respuesta {

	private Integer estado;

    private String mensaje;

	public Respuesta() {
		super();
	}

	public Respuesta(Integer estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Respuesta [estado=" + estado + ", mensaje=" + mensaje + "]";
	}
    
}
