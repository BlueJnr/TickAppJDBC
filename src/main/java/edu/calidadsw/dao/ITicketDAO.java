package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.Ticket;

public interface ITicketDAO {
    List<Ticket> getAllTickets();
    Ticket getTicketById(int idTicket);
    int addTicket(Ticket ticket);
    int addTicketCola(Ticket ticket);
    int updateTicket(Ticket ticket);
    int cancelarTicket(Ticket ticket);
    int validarTicket(Ticket ticket);
    int validarHoraReserva(int idComida);
    int validarReserva(int idUsuario, int idComida);
    int validarCantidadNivelTurno(int idComida, int idNivelTurno);
    Ticket removeTicketCola(Ticket ticket);
    void deleteTicket(int idTicket);
}
