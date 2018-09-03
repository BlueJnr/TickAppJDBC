package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.ITicketDAO;
import edu.calidadsw.entity.NivelTurno2;
import edu.calidadsw.entity.Ticket;
import edu.calidadsw.entity.rowmapper.TicketRowMapper;
import edu.calidadsw.singleton.Nivel1Turno1;
import edu.calidadsw.singleton.Nivel1Turno2;
import edu.calidadsw.singleton.Nivel1Turno3;
import edu.calidadsw.singleton.Nivel1Turno4;
import edu.calidadsw.singleton.Nivel1Turno5;
import edu.calidadsw.singleton.Nivel2Turno1;
import edu.calidadsw.singleton.Nivel2Turno2;
import edu.calidadsw.singleton.Nivel2Turno3;
import edu.calidadsw.singleton.Nivel2Turno4;
import edu.calidadsw.singleton.Nivel2Turno5;

@Transactional
@Repository
public class TicketDAOImpl implements ITicketDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Ticket getTicketById(int idTicket) {
		String sql = "SELECT id_ticket, numero, estado, id_usuario, id_nt, id_comida FROM ticket WHERE id_ticket = ?";
		RowMapper<Ticket> rowMapper = new BeanPropertyRowMapper<Ticket>(Ticket.class);
		Ticket ticket = jdbcTemplate.queryForObject(sql, rowMapper, idTicket);
		return ticket;
	}

	@Override
	public List<Ticket> getAllTickets() {
		String sql = "SELECT id_ticket, numero, estado, id_usuario, id_nt, id_comida FROM ticket";
		// RowMapper<Ticket> rowMapper = new
		// BeanPropertyRowMapper<Ticket>(Ticket.class);
		RowMapper<Ticket> rowMapper = new TicketRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int addTicket(Ticket ticket) {
		// Add ticket
		String sql = "select * from insert_ticket(?, ?, ?)";
		return jdbcTemplate.queryForObject(sql, Integer.class, ticket.getIdUsuario(), ticket.getIdNt(),
				ticket.getIdComida());

	}

	@Override
	public int addTicketCola(Ticket ticket) {
		int posicion = 0;

		String sql = "select nivel, turno from nivel_turno where id_nt = ?";
		RowMapper<NivelTurno2> rowMapper = new BeanPropertyRowMapper<NivelTurno2>(NivelTurno2.class);
		NivelTurno2 nivelTurno2 = jdbcTemplate.queryForObject(sql, rowMapper, ticket.getIdNt());

		switch (nivelTurno2.getTurno()) {
		case 1:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno1 nivel1Turno1 = Nivel1Turno1.getInstance();
				nivel1Turno1.list().add(ticket);
				posicion = nivel1Turno1.list().size();
				break;
			case 2:
				Nivel2Turno1 nivel2Turno1 = Nivel2Turno1.getInstance();
				nivel2Turno1.list().add(ticket);
				posicion = nivel2Turno1.list().size();
				break;
			}
			break;
		case 2:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno2 nivel1Turno2 = Nivel1Turno2.getInstance();
				nivel1Turno2.list().add(ticket);
				posicion = nivel1Turno2.list().size();
				break;
			case 2:
				Nivel2Turno2 nivel2Turno2 = Nivel2Turno2.getInstance();
				nivel2Turno2.list().add(ticket);
				posicion = nivel2Turno2.list().size();
				break;
			}
			break;
		case 3:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno3 nivel1Turno3 = Nivel1Turno3.getInstance();
				nivel1Turno3.list().add(ticket);
				posicion = nivel1Turno3.list().size();
				break;
			case 2:
				Nivel2Turno3 nivel2Turno3 = Nivel2Turno3.getInstance();
				nivel2Turno3.list().add(ticket);
				posicion = nivel2Turno3.list().size();
				break;
			}
			break;
		case 4:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno4 nivel1Turno4 = Nivel1Turno4.getInstance();
				nivel1Turno4.list().add(ticket);
				posicion = nivel1Turno4.list().size();
				break;
			case 2:
				Nivel2Turno4 nivel2Turno4 = Nivel2Turno4.getInstance();
				nivel2Turno4.list().add(ticket);
				posicion = nivel2Turno4.list().size();
				break;
			}
			break;
		case 5:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno5 nivel1Turno5 = Nivel1Turno5.getInstance();
				nivel1Turno5.list().add(ticket);
				posicion = nivel1Turno5.list().size();
				break;
			case 2:
				Nivel2Turno5 nivel2Turno5 = Nivel2Turno5.getInstance();
				nivel2Turno5.list().add(ticket);
				posicion = nivel2Turno5.list().size();
				break;
			}
			break;
		}
		if(posicion!=0) {
			sql = "UPDATE USUARIO SET estado = 'ESPERANDO' WHERE id_usuario = ?";
			jdbcTemplate.update(sql, ticket.getIdUsuario());
		}
		return posicion;
	}

	@Override
	public int updateTicket(Ticket ticket) {
		String sql = "UPDATE TICKET SET id_usuario = null, estado='DISPONIBLE' WHERE id_ticket = ?";
		return jdbcTemplate.update(sql, ticket.getIdTicket());

	}

	@Override
	public int cancelarTicket(Ticket ticket) {
		String sql = "select * from cancelar_ticket(?, ?)";
		return jdbcTemplate.queryForObject(sql, Integer.class, ticket.getIdUsuario(), ticket.getIdTicket());
	}

	@Override
	public int validarTicket(Ticket ticket) {
		String sql = "select * from validar_ticket(?, ?)";
		return jdbcTemplate.queryForObject(sql, Integer.class, ticket.getIdUsuario(), ticket.getIdTicket());
	}

	@Override
	public int validarHoraReserva(int idComida) {
		String sql = "select * from validar_hora_reserva(?)";
		return jdbcTemplate.queryForObject(sql, Integer.class, idComida);
	}

	@Override
	public int validarReserva(int idUsuario, int idComida) {
		String sql = "SELECT * FROM validar_reserva(?, ?)";
		// RowMapper<Accede> rowMapper = new
		// BeanPropertyRowMapper<Accede>(Accede.class);
		int resp = jdbcTemplate.queryForObject(sql, Integer.class, idUsuario, idComida);
		System.out.println("respuestaa -> " + resp);
		return resp;
	}

	@Override
	public int validarCantidadNivelTurno(int idComida, int idNivelTurno) {
		String sql = "SELECT * FROM validar_cantidad_nt(?, ?)";
		// RowMapper<Accede> rowMapper = new
		// BeanPropertyRowMapper<Accede>(Accede.class);
		return jdbcTemplate.queryForObject(sql, Integer.class, idComida, idNivelTurno);
	}

	@Override
	public Ticket removeTicketCola(Ticket ticket) {
		Ticket ticketCola = null ;

		String sql = "select nivel, turno from nivel_turno where id_nt = ?";
		RowMapper<NivelTurno2> rowMapper = new BeanPropertyRowMapper<NivelTurno2>(NivelTurno2.class);
		NivelTurno2 nivelTurno2 = jdbcTemplate.queryForObject(sql, rowMapper, ticket.getIdNt());

		switch (nivelTurno2.getTurno()) {
		case 1:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno1 nivel1Turno1 = Nivel1Turno1.getInstance();
				ticketCola = nivel1Turno1.list().remove(0);
				break;
			case 2:
				Nivel2Turno1 nivel2Turno1 = Nivel2Turno1.getInstance();
				ticketCola = nivel2Turno1.list().remove(0);
				break;
			}
			break;
		case 2:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno2 nivel1Turno2 = Nivel1Turno2.getInstance();
				ticketCola = nivel1Turno2.list().remove(0);
				break;
			case 2:
				Nivel2Turno2 nivel2Turno2 = Nivel2Turno2.getInstance();
				ticketCola = nivel2Turno2.list().remove(0);
				break;
			}
			break;
		case 3:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno3 nivel1Turno3 = Nivel1Turno3.getInstance();
				ticketCola = nivel1Turno3.list().remove(0);
				break;
			case 2:
				Nivel2Turno3 nivel2Turno3 = Nivel2Turno3.getInstance();
				ticketCola = nivel2Turno3.list().remove(0);
				break;
			}
			break;
		case 4:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno4 nivel1Turno4 = Nivel1Turno4.getInstance();
				ticketCola = nivel1Turno4.list().remove(0);
				break;
			case 2:
				Nivel2Turno4 nivel2Turno4 = Nivel2Turno4.getInstance();
				ticketCola = nivel2Turno4.list().remove(0);
				break;
			}
			break;
		case 5:
			switch (nivelTurno2.getNivel()) {
			case 1:
				Nivel1Turno5 nivel1Turno5 = Nivel1Turno5.getInstance();
				ticketCola = nivel1Turno5.list().remove(0);
				break;
			case 2:
				Nivel2Turno5 nivel2Turno5 = Nivel2Turno5.getInstance();
				ticketCola = nivel2Turno5.list().remove(0);
				break;
			}
			break;
		}
		return ticketCola;
	}

	@Override
	public void deleteTicket(int idTicket) {
		String sql = "DELETE FROM ticket WHERE id_ticket = ?";
		jdbcTemplate.update(sql, idTicket);
	}

}