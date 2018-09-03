package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.Ticket;
public class TicketRowMapper implements RowMapper<Ticket> {
	@Override
	public Ticket mapRow(ResultSet row, int rowNum) throws SQLException {
		Ticket ticket = new Ticket();
		ticket.setIdTicket(row.getInt("id_ticket"));
		ticket.setNumero(row.getInt("numero"));
		ticket.setEstado(row.getString("estado"));
		ticket.setIdUsuario(row.getInt("id_usuario"));
		ticket.setIdNt(row.getInt("id_nt"));
		ticket.setIdComida(row.getInt("id_comida"));
		return ticket;
	}
} 