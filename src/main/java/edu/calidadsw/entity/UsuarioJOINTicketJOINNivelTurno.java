package edu.calidadsw.entity;

public class UsuarioJOINTicketJOINNivelTurno {

	private Integer idUsuario;

    private String nombres;

    private String apePat;

    private String apeMat;

    private String codigo;

    private String user;
    
    private Integer idTicket;

    private Integer numero;

    private String estado;
    
    private Integer idNt;

    private Integer nivel;

    private Integer turno;

	public UsuarioJOINTicketJOINNivelTurno() {
		super();
	}

	public UsuarioJOINTicketJOINNivelTurno(Integer idUsuario, String nombres, String apePat, String apeMat,
			String codigo, String user, Integer idTicket, Integer numero, String estado, Integer idNt, Integer nivel,
			Integer turno) {
		super();
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.codigo = codigo;
		this.user = user;
		this.idTicket = idTicket;
		this.numero = numero;
		this.estado = estado;
		this.idNt = idNt;
		this.nivel = nivel;
		this.turno = turno;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "UsuarioJOINTicketJOINComidaJOINNivelTurno [idUsuario=" + idUsuario + ", nombres=" + nombres
				+ ", apePat=" + apePat + ", apeMat=" + apeMat + ", codigo=" + codigo + ", user=" + user + ", idTicket="
				+ idTicket + ", numero=" + numero + ", estado=" + estado + ", idNt=" + idNt + ", nivel=" + nivel
				+ ", turno=" + turno + "]";
	}

	
    
}
