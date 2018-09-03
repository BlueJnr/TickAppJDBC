package edu.calidadsw.entity;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuario;

    private String nombres;

    private String apePat;

    private String apeMat;

    private String codigo;

    private String dni;

    private String user;

    private String password;

    private String telefono;

    private String estado;

    private Integer idTu;

    public Usuario() {
    }

    public Usuario( Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario( Integer idUsuario, String nombres, String apePat, String apeMat, String codigo, String dni, String user, String password, String telefono, String estado) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.codigo = codigo;
        this.dni = dni;
        this.user = user;
        this.password = password;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario( Integer idUsuario) {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombres=" + nombres + ", apePat=" + apePat + ", apeMat=" + apeMat
				+ ", codigo=" + codigo + ", dni=" + dni + ", user=" + user + ", password=" + password + ", telefono="
				+ telefono + ", estado=" + estado + ", idTu=" + idTu + "]";
	}
    
}
