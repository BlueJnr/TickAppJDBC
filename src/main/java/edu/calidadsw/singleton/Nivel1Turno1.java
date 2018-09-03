package edu.calidadsw.singleton;

import java.util.ArrayList;
import java.util.List;

import edu.calidadsw.entity.Ticket;

public class Nivel1Turno1 {

	List<Ticket> list;
	// create an object of Nivel1Turno1
	private static Nivel1Turno1 instance = new Nivel1Turno1();

	// make the constructor private so that this class cannot be
	// instantiated
	private Nivel1Turno1() {
	}

	// Get the only object available
	public static Nivel1Turno1 getInstance() {
		return instance;
	}

	public List<Ticket> list() {
		if(list==null) {
			list = new ArrayList<Ticket>();
		}
		return list;
	}
}