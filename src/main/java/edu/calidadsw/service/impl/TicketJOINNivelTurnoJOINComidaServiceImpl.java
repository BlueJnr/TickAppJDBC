package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.ITicketJOINNivelTurnoJOINComidaDAO;
import edu.calidadsw.entity.TicketJOINNivelTurnoJOINComida;
import edu.calidadsw.service.ITicketJOINNivelTurnoJOINComidaService;

@Service
public class TicketJOINNivelTurnoJOINComidaServiceImpl implements ITicketJOINNivelTurnoJOINComidaService {
	@Autowired
	private ITicketJOINNivelTurnoJOINComidaDAO ticketJOINNivelTurnoJOINComidaDAO;

	@Override
	public List<TicketJOINNivelTurnoJOINComida> getAllTicketJOINNivelTurnoJOINComidas(int idUsuario) {
		return ticketJOINNivelTurnoJOINComidaDAO.getAllTicketJOINNivelTurnoJOINComidas(idUsuario);
	}

}