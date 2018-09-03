package edu.calidadsw.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Comida implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idComida;

    private String nombre;

    private String descripcion;

    private Integer numRaciones;

    private Date dia;

    private String comidaTipo;

    private Time inicioReserva;

    private Time finReserva;

    public Comida() {
    }

    public Comida(Integer idComida) {
        this.idComida = idComida;
    }

    public Comida(Integer idComida, String nombre, String descripcion, Integer numRaciones, Date dia, String comidaTipo, Time inicioReserva, Time finReserva) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numRaciones = numRaciones;
        this.dia = dia;
        this.comidaTipo = comidaTipo;
        this.inicioReserva = inicioReserva;
        this.finReserva = finReserva;
    }

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumRaciones() {
        return numRaciones;
    }

    public void setNumRaciones(Integer numRaciones) {
        this.numRaciones = numRaciones;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getComidaTipo() {
        return comidaTipo;
    }

    public void setComidaTipo(String comidaTipo) {
        this.comidaTipo = comidaTipo;
    }

    public Date getInicioReserva() {
        return inicioReserva;
    }

    public void setInicioReserva(Time inicioReserva) {
        this.inicioReserva = inicioReserva;
    }

    public Date getFinReserva() {
        return finReserva;
    }

    public void setFinReserva(Time finReserva) {
        this.finReserva = finReserva;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idComida == null) ? 0 : idComida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comida other = (Comida) obj;
		if (idComida == null) {
			if (other.idComida != null)
				return false;
		} else if (!idComida.equals(other.idComida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comida [idComida=" + idComida + ", nombre=" + nombre + ", descripcion=" + descripcion + ", numRaciones="
				+ numRaciones + ", dia=" + dia + ", comidaTipo=" + comidaTipo + ", inicioReserva=" + inicioReserva
				+ ", finReserva=" + finReserva + "]";
	}
    
}
