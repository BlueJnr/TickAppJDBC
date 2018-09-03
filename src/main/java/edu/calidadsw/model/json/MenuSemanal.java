package edu.calidadsw.model.json;

import java.util.List;

import edu.calidadsw.entity.Comida;


public class MenuSemanal {
	
	private List<Comida> Lunes = null;
	private List<Comida> Martes = null;
	private List<Comida> Miercoles = null;
	private List<Comida> Jueves = null;
	private List<Comida> Viernes = null;
	private List<Comida> Sabado = null;
	private List<Comida> Domingo = null;

	public List<Comida> getLunes() {
		return Lunes;
	}

	public void setLunes(List<Comida> lunes) {
		Lunes = lunes;
	}

	public List<Comida> getMartes() {
		return Martes;
	}

	public void setMartes(List<Comida> martes) {
		Martes = martes;
	}

	public List<Comida> getMiercoles() {
		return Miercoles;
	}

	public void setMiercoles(List<Comida> miércoles) {
		Miercoles = miércoles;
	}

	public List<Comida> getJueves() {
		return Jueves;
	}

	public void setJueves(List<Comida> jueves) {
		Jueves = jueves;
	}

	public List<Comida> getViernes() {
		return Viernes;
	}

	public void setViernes(List<Comida> vieres) {
		Viernes = vieres;
	}

	public List<Comida> getSabado() {
		return Sabado;
	}

	public void setSabado(List<Comida> sábado) {
		Sabado = sábado;
	}

	public List<Comida> getDomingo() {
		return Domingo;
	}

	public void setDomingo(List<Comida> domingo) {
		Domingo = domingo;
	}

	@Override
	public String toString() {
		return "MenuSemanal [Lunes=" + Lunes + ", Martes=" + Martes + ", Miercoles=" + Miercoles + ", Jueves=" + Jueves
				+ ", Viernes=" + Viernes + ", Sabado=" + Sabado + ", Domingo=" + Domingo + "]";
	}


}