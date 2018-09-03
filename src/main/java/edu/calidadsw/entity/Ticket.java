/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.calidadsw.entity;

import java.io.Serializable;

public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idTicket;

    private Integer numero;

    private String estado;

    private Integer idComida;

    private Integer idNt;

    private Integer idUsuario;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Integer idTicket, Integer numero, String estado) {
        this.idTicket = idTicket;
        this.numero = numero;
        this.estado = estado;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
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

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public Integer getIdNt() {
        return idNt;
    }

    public void setIdNt(Integer idNt) {
        this.idNt = idNt;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTicket == null) ? 0 : idTicket.hashCode());
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
		Ticket other = (Ticket) obj;
		if (idTicket == null) {
			if (other.idTicket != null)
				return false;
		} else if (!idTicket.equals(other.idTicket))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", numero=" + numero + ", estado=" + estado + ", idComida=" + idComida
				+ ", idNt=" + idNt + ", idUsuario=" + idUsuario + "]";
	}
 
}
