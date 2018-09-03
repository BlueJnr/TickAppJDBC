package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.ITicketJOINNivelTurnoJOINComidaDAO;
import edu.calidadsw.entity.TicketJOINNivelTurnoJOINComida;
import edu.calidadsw.entity.rowmapper.TicketJOINNivelTurnoJOINComidaRowMapper;

@Transactional
@Repository
public class TicketJOINNivelTurnoJOINComidaDAOImpl implements ITicketJOINNivelTurnoJOINComidaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TicketJOINNivelTurnoJOINComida> getAllTicketJOINNivelTurnoJOINComidas(int idUsuario) {
		String sql = "SELECT TI.id_ticket, CO.nombre, CO.comida_tipo, NT.nivel, NT.turno, NT.hora_inicio, NT.hora_fin, TI.numero, TI.estado FROM TICKET TI, NIVEL_TURNO NT, COMIDA CO WHERE CO.dia = current_date AND TI.id_usuario = ? AND TI.id_comida = CO.id_comida AND TI.id_nt = NT.id_nt ORDER BY id_ticket DESC LIMIT 1";
		// RowMapper<TicketJOINNivelTurnoJOINComida> rowMapper = new
		// BeanPropertyRowMapper<TicketJOINNivelTurnoJOINComida>(TicketJOINNivelTurnoJOINComida.class);
		RowMapper<TicketJOINNivelTurnoJOINComida> rowMapper = new TicketJOINNivelTurnoJOINComidaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, idUsuario);
	}

}
