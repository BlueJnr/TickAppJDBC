package edu.calidadsw.entity;

import java.io.Serializable;

public class Accede implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAccede;

    private Integer idComida;

    private Integer idTu;

    public Accede() {
    }

    public Accede(Integer idAccede) {
        this.idAccede = idAccede;
    }

    public Integer getIdAccede() {
        return idAccede;
    }

    public void setIdAccede(Integer idAccede) {
        this.idAccede = idAccede;
    }

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public Integer getIdTu() {
        return idTu;
    }

    public void setIdTu(Integer idTu) {
        this.idTu = idTu;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAccede == null) ? 0 : idAccede.hashCode());
		result = prime * result + ((idComida == null) ? 0 : idComida.hashCode());
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
		Accede other = (Accede) obj;
		if (idAccede == null) {
			if (other.idAccede != null)
				return false;
		} else if (!idAccede.equals(other.idAccede))
			return false;
		if (idComida == null) {
			if (other.idComida != null)
				return false;
		} else if (!idComida.equals(other.idComida))
			return false;
		if (idTu == null) {
			if (other.idTu != null)
				return false;
		} else if (!idTu.equals(other.idTu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accede [idAccede=" + idAccede + ", idComida=" + idComida + ", idTu=" + idTu + "]";
	}

    
}
