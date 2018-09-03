package edu.calidadsw.model.json;

public class UpdateAccesoComida {
	
	private Integer idComida;
	
	private Boolean profesor;
	
	private Boolean alumno;
	
	private Boolean residente;

	public Integer getIdComida() {
		return idComida;
	}

	public void setIdComida(Integer idComida) {
		this.idComida = idComida;
	}

	public Boolean getProfesor() {
		return profesor;
	}

	public void setProfesor(Boolean profesor) {
		this.profesor = profesor;
	}

	public Boolean getAlumno() {
		return alumno;
	}

	public void setAlumno(Boolean alumno) {
		this.alumno = alumno;
	}

	public Boolean getResidente() {
		return residente;
	}

	public void setResidente(Boolean residente) {
		this.residente = residente;
	}

	@Override
	public String toString() {
		return "UpdateAccesoComida [idComida=" + idComida + ", profesor=" + profesor + ", alumno=" + alumno
				+ ", residente=" + residente + "]";
	}

}
