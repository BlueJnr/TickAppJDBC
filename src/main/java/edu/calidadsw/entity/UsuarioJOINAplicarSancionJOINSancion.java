package edu.calidadsw.entity;

import java.util.Date;

public class UsuarioJOINAplicarSancionJOINSancion {

	private Integer idUsuario;

    private String nombres;
    
    private String apePat;
    
    private String apeMat;

    private String codigo;
	
	private Integer idAplica;

    private Date inicio;

    private Date fin;
    
    private Integer idSancion;

    private String nombreSancion;

	public UsuarioJOINAplicarSancionJOINSancion() {
		super();
	}

	public UsuarioJOINAplicarSancionJOINSancion(Integer idUsuario, String nombres, String apePat, String apeMat,
			String codigo, Integer idAplica, Date inicio, Date fin, Integer idSancion, String nombreSancion) {
		super();
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.codigo = codigo;
		this.idAplica = idAplica;
		this.inicio = inicio;
		this.fin = fin;
		this.idSancion = idSancion;
		this.nombreSancion = nombreSancion;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getNombreSancion() {
		return nombreSancion;
	}

	public void setNombreSancion(String nombreSancion) {
		this.nombreSancion = nombreSancion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAplica == null) ? 0 : idAplica.hashCode());
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
		UsuarioJOINAplicarSancionJOINSancion other = (UsuarioJOINAplicarSancionJOINSancion) obj;
		if (idAplica == null) {
			if (other.idAplica != null)
				return false;
		} else if (!idAplica.equals(other.idAplica))
			return false;
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
		return "UsuarioJOINAplicarSancionJOINSancion [idUsuario=" + idUsuario + ", nombres=" + nombres + ", apePat="
				+ apePat + ", apeMat=" + apeMat + ", codigo=" + codigo + ", idAplica=" + idAplica + ", inicio=" + inicio
				+ ", fin=" + fin + ", idSancion=" + idSancion + ", nombreSancion=" + nombreSancion + "]";
	}


   
}
