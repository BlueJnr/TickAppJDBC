package edu.calidadsw.entity;

import java.io.Serializable;
import java.util.Date;

public class AplicarSancion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAplica;

    private Date inicio;

    private Date fin;

    private Integer idSancion;

    private Integer idUsuario;

    public AplicarSancion() {
    }

    public AplicarSancion(Integer idAplica) {
        this.idAplica = idAplica;
    }

    public AplicarSancion(Integer idAplica, Date inicio, Date fin) {
        this.idAplica = idAplica;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Integer getIdAplica() {
        return idAplica;
    }

    public void setIdAplica(Integer idAplica) {
        this.idAplica = idAplica;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Integer getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(Integer idSancion) {
        this.idSancion = idSancion;
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
		result = prime * result + ((idAplica == null) ? 0 : idAplica.hashCode());
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
		AplicarSancion other = (AplicarSancion) obj;
		if (idAplica == null) {
			if (other.idAplica != null)
				return false;
		} else if (!idAplica.equals(other.idAplica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AplicarSancion [idAplica=" + idAplica + ", inicio=" + inicio + ", fin=" + fin + ", idSancion="
				+ idSancion + ", idUsuario=" + idUsuario + "]";
	}
   
}
