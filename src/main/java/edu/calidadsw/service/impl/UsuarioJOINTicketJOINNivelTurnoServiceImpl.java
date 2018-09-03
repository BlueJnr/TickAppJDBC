package edu.calidadsw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.IUsuarioJOINTicketJOINNivelTurnoDAO;
import edu.calidadsw.entity.UsuarioJOINTicketJOINNivelTurno;
import edu.calidadsw.service.IUsuarioJOINTicketJOINNivelTurnoService;

@Service
public class UsuarioJOINTicketJOINNivelTurnoServiceImpl implements IUsuarioJOINTicketJOINNivelTurnoService{

	@Autowired
	private IUsuarioJOINTicketJOINNivelTurnoDAO usuarioJOINTicketJOINNivelTurnoDAO;
	@Override
	public UsuarioJOINTicketJOINNivelTurno getUsuarioJOINTicketJOINNivelTurnoById(String codigo, String comidaTipo) {
		return usuarioJOINTicketJOINNivelTurnoDAO.getUsuarioJOINTicketJOINNivelTurnoById(codigo,comidaTipo);

	}

}
