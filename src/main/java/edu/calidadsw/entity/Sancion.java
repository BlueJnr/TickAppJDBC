/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.calidadsw.entity;

import java.io.Serializable;

public class Sancion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idSancion;

    private String nombreSancion;

    private Integer duracion;

    public Sancion() {
    }

    public Sancion(Integer idSancion) {
        this.idSancion = idSancion;
    }

    public Sancion(Integer idSancion, String nombreSancion, Integer duracion) {
        this.idSancion = idSancion;
        this.nombreSancion = nombreSancion;
        this.duracion = duracion;
    }

    public Integer getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Integer idSancion) {
        this.idSancion = idSancion;
    }

    public String getNombreSancion() {
        return nombreSancion;
    }

    public void setNombreSancion(String nombreSancion) {
        this.nombreSancion = nombreSancion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSancion == null) ? 0 : idSancion.hashCode());
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
		Sancion other = (Sancion) obj;
		if (idSancion == null) {
			if (other.idSancion != null)
				return false;
		} else if (!idSancion.equals(other.idSancion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sancion [idSancion=" + idSancion + ", nombreSancion=" + nombreSancion + ", duracion=" + duracion + "]";
	}
    
}
