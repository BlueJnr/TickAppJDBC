package edu.calidadsw.singleton;

import java.util.ArrayList;
import java.util.List;

import edu.calidadsw.entity.Ticket;

public class Nivel2Turno2 {

	List<Ticket> list;
	// create an object of Nivel2Turno2
	private static Nivel2Turno2 instance = new Nivel2Turno2();

	// make the constructor private so that this class cannot be
	// instantiated
	private Nivel2Turno2() {
	}

	// Get the only object available
	public static Nivel2Turno2 getInstance() {
		return instance;
	}

	public List<Ticket> list() {
		if(list==null) {
			list = new ArrayList<Ticket>();
		}
		return list;
	}
}
