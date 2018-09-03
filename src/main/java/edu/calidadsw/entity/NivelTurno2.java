package edu.calidadsw.entity;

public class NivelTurno2 {

	private Integer nivel;

    private Integer turno;

	public NivelTurno2() {
		super();
	}

	public NivelTurno2(Integer nivel, Integer turno) {
		super();
		this.nivel = nivel;
		this.turno = turno;
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
		return "NivelTurno2 [nivel=" + nivel + ", turno=" + turno + "]";
	}
    
    
}
