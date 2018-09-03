package edu.calidadsw.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class NivelTurno implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idNt;

    private Integer nivel;

    private Integer turno;

    private Time horaInicio;

    private Time horaFin;

    private Integer numTickets;

    private Integer idComida;

    public NivelTurno() {
    }

    public NivelTurno(Integer idNt) {
        this.idNt = idNt;
    }

    public NivelTurno(Integer idNt, Integer nivel, Integer turno, Time horaInicio, Time horaFin, Integer numTickets) {
        this.idNt = idNt;
        this.nivel = nivel;
        this.turno = turno;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.numTickets = numTickets;
    }

    public Integer getIdNt() {
        return idNt;
    }

    public void setIdNt(Integer idNt) {
        this.idNt = idNt;
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

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(Integer numTickets) {
        this.numTickets = numTickets;
    }

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNt == null) ? 0 : idNt.hashCode());
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
		NivelTurno other = (NivelTurno) obj;
		if (idNt == null) {
			if (other.idNt != null)
				return false;
		} else if (!idNt.equals(other.idNt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NivelTurno [idNt=" + idNt + ", nivel=" + nivel + ", turno=" + turno + ", horaInicio=" + horaInicio
				+ ", horaFin=" + horaFin + ", numTickets=" + numTickets + ", idComida=" + idComida + "]";
	}
    
}
