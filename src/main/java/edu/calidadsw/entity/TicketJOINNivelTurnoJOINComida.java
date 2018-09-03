package edu.calidadsw.entity;

import java.sql.Time;

public class TicketJOINNivelTurnoJOINComida {

	private String idTicket;
	
	private String nombre;

    private String comidaTipo;
    
    private Integer nivel;

    private Integer turno;

    private Time horaInicio;

    private Time horaFin;
    
    private Integer numero;

    private String estado;

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}

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

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "TicketJOINNivelTurnoJOINComida [idTicket=" + idTicket + ", nombre=" + nombre + ", comidaTipo="
				+ comidaTipo + ", nivel=" + nivel + ", turno=" + turno + ", horaInicio=" + horaInicio + ", horaFin="
				+ horaFin + ", numero=" + numero + ", estado=" + estado + "]";
	}

	
}
