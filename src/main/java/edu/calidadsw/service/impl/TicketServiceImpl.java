package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.ITicketDAO;
import edu.calidadsw.entity.Ticket;
import edu.calidadsw.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService {
	@Autowired
	private ITicketDAO ticketDAO;
	@Override
	public Ticket getTicketById(int idTicket) {
		Ticket obj = ticketDAO.getTicketById(idTicket);
		return obj;
	}	
	@Override
	public List<Ticket> getAllTickets(){
		return ticketDAO.getAllTickets();
	}
	@Override
	public int addTicket(Ticket ticket){               
		return ticketDAO.addTicket(ticket);
	}
	@Override
	public int addTicketCola(Ticket ticket) {
		return ticketDAO.addTicketCola(ticket);
	}
	@Override
	public int updateTicket(Ticket ticket) {
		return ticketDAO.updateTicket(ticket);
	}
	@Override
	public int cancelarTicket(Ticket ticket) {
		return ticketDAO.cancelarTicket(ticket);
	}
	@Override
	public int validarTicket(Ticket ticket) {
		return ticketDAO.validarTicket(ticket);
	}
	@Override
	public int validarHoraReserva(int idComida) {
		return ticketDAO.validarHoraReserva(idComida);
	}
	@Override
	public int validarReserva(int idUsuario, int idComida) {
		return ticketDAO.validarReserva(idUsuario, idComida);
	}
	@Override
	public int validarCantidadNivelTurno(int idComida, int idNivelTurno) {
		return ticketDAO.validarCantidadNivelTurno(idComida, idNivelTurno);
	}
	@Override
	public Ticket removeTicketCola(Ticket ticket) {
		return ticketDAO.removeTicketCola(ticket);
	}
	@Override
	public void deleteTicket(int idTicket) {
		ticketDAO.deleteTicket(idTicket);
	}


}

