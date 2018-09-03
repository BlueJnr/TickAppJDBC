package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.INivelTurnoDAO;
import edu.calidadsw.entity.NivelTurno;
import edu.calidadsw.entity.rowmapper.NivelTurnoRowMapper;

@Transactional
@Repository
public class NivelTurnoDAOImpl implements INivelTurnoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public NivelTurno getNivelTurnoById(int idNivelTurno) {
		String sql = "SELECT id_nt, nivel, turno, hora_inicio, hora_fin, num_tickets, id_comida FROM nivel_turno WHERE id_nt = ?";
		RowMapper<NivelTurno> rowMapper = new BeanPropertyRowMapper<NivelTurno>(NivelTurno.class);
		NivelTurno nivelTurno = jdbcTemplate.queryForObject(sql, rowMapper, idNivelTurno);
		return nivelTurno;
	}

	@Override
	public int getIdNivelTurnoByIdComidaNivelTurno(int idComida, int nivel, int turno) {
		String sql = "select id_nt from nivel_turno where id_comida = ? and nivel = ? and turno = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, idComida, nivel, turno);
	}

	@Override
	public List<NivelTurno> getAllNivelTurnos() {
		String sql = "SELECT id_nt, nivel, turno, hora_inicio, hora_fin, num_tickets, id_comida FROM nivel_turno";
		// RowMapper<NivelTurno> rowMapper = new
		// BeanPropertyRowMapper<NivelTurno>(NivelTurno.class);
		RowMapper<NivelTurno> rowMapper = new NivelTurnoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<NivelTurno> getAllNivelTurnosByIdComida(int idComida) {
		String sql = "SELECT id_nt, nivel, turno, hora_inicio, hora_fin, num_tickets, id_comida FROM nivel_turno WHERE id_comida = ?";
		// RowMapper<NivelTurno> rowMapper = new
		// BeanPropertyRowMapper<NivelTurno>(NivelTurno.class);
		RowMapper<NivelTurno> rowMapper = new NivelTurnoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, idComida);
	}

	@Override
	public int addNivelTurno(NivelTurno nivelTurno) {
		// Add nivelTurno
		String sql = "INSERT INTO nivel_turno (id_nt, nivel, turno, hora_inicio, hora_fin, num_tickets, id_comida) values (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, nivelTurno.getIdNt(), nivelTurno.getNivel(), nivelTurno.getTurno(),
				nivelTurno.getHoraInicio(), nivelTurno.getHoraFin(), nivelTurno.getNumTickets(),
				nivelTurno.getIdComida());

	}

	@Override
	public int updateNivelTurno(NivelTurno nivelTurno) {
		String sql = "UPDATE NIVEL_TURNO SET num_tickets = ? WHERE id_nt = ?";
		return jdbcTemplate.update(sql, nivelTurno.getNumTickets(), nivelTurno.getIdNt());

	}

	@Override
	public void deleteNivelTurno(int idNivelTurno) {
		String sql = "DELETE FROM nivel_turno WHERE id_nt = ?";
		jdbcTemplate.update(sql, idNivelTurno);
	}

}
