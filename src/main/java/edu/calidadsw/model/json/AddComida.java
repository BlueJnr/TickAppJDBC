package edu.calidadsw.model.json;

import java.util.Date;

public class AddComida {
	private String nombre;

	private String comidaTipo;

	private String descripcion;

	private Date dia;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComidaTipo() {
		return comidaTipo;
	}

	public void setComidaTipo(String comidaTipo) {
		this.comidaTipo = comidaTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "AddComida [nombre=" + nombre + ", comidaTipo=" + comidaTipo + ", descripcion=" + descripcion + ", dia="
				+ dia + "]";
	}

}
