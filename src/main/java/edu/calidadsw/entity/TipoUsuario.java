/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.calidadsw.entity;

import java.io.Serializable;

public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idTu;

    private String nombreTu;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTu) {
        this.idTu = idTu;
    }

    public TipoUsuario(Integer idTu, String nombreTu) {
        this.idTu = idTu;
        this.nombreTu = nombreTu;
    }

    public Integer getIdTu() {
        return idTu;
    }

    public void setIdTu(Integer idTu) {
        this.idTu = idTu;
    }

    public String getNombreTu() {
        return nombreTu;
    }

    public void setNombreTu(String nombreTu) {
        this.nombreTu = nombreTu;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTu == null) ? 0 : idTu.hashCode());
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
		TipoUsuario other = (TipoUsuario) obj;
		if (idTu == null) {
			if (other.idTu != null)
				return false;
		} else if (!idTu.equals(other.idTu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoUsuario [idTu=" + idTu + ", nombreTu=" + nombreTu + "]";
	}
    
}
