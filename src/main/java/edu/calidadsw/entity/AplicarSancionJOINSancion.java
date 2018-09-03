package edu.calidadsw.entity;

import java.util.Date;

public class AplicarSancionJOINSancion {
    
    private Integer idSancion;

    private String nombreSancion;
    
	private Integer idUsuario;

    private Date inicio;

    private Date fin;

	public AplicarSancionJOINSancion() {
		super();
	}

	public AplicarSancionJOINSancion(Integer idSancion, String nombreSancion, Integer idUsuario, Date inicio,
			Date fin) {
		super();
		this.idSancion = idSancion;
		this.nombreSancion = nombreSancion;
		this.idUsuario = idUsuario;
		this.inicio = inicio;
		this.fin = fin;
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSancion == null) ? 0 : idSancion.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		AplicarSancionJOINSancion other = (AplicarSancionJOINSancion) obj;
		if (idSancion == null) {
			if (other.idSancion != null)
				return false;
		} else if (!idSancion.equals(other.idSancion))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AplicarSancionJOINSancion [idSancion=" + idSancion + ", nombreSancion=" + nombreSancion + ", idUsuario="
				+ idUsuario + ", inicio=" + inicio + ", fin=" + fin + "]";
	}

}
