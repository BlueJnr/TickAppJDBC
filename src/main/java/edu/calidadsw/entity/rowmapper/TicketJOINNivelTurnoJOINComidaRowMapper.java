package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.TicketJOINNivelTurnoJOINComida;
public class TicketJOINNivelTurnoJOINComidaRowMapper implements RowMapper<TicketJOINNivelTurnoJOINComida> {
	@Override
	public TicketJOINNivelTurnoJOINComida mapRow(ResultSet row, int rowNum) throws SQLException {
		TicketJOINNivelTurnoJOINComida ticketJOINNivelTurnoJOINComida = new TicketJOINNivelTurnoJOINComida();
		ticketJOINNivelTurnoJOINComida.setIdTicket((row.getString("id_ticket")));
		ticketJOINNivelTurnoJOINComida.setNombre(row.getString("nombre"));
		ticketJOINNivelTurnoJOINComida.setComidaTipo(row.getString("comida_tipo"));
		ticketJOINNivelTurnoJOINComida.setNivel(row.getInt("nivel"));
		ticketJOINNivelTurnoJOINComida.setTurno(row.getInt("turno"));
		ticketJOINNivelTurnoJOINComida.setHoraInicio(row.getTime("hora_inicio"));
		ticketJOINNivelTurnoJOINComida.setHoraFin(row.getTime("hora_fin"));
		ticketJOINNivelTurnoJOINComida.setNumero(row.getInt("numero"));
		ticketJOINNivelTurnoJOINComida.setEstado(row.getString("estado"));
		return ticketJOINNivelTurnoJOINComida;
	}
}
