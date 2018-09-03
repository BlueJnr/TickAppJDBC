package edu.calidadsw.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.IComidaDAO;
import edu.calidadsw.entity.Comida;
import edu.calidadsw.entity.rowmapper.ComidaRowMapper;
import edu.calidadsw.model.json.AddComida;

@Transactional
@Repository
public class ComidaDAOImpl implements IComidaDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Comida getComidaById(int idComida) {
		String sql = "SELECT id_comida, nombre, descripcion, num_raciones, dia, comida_tipo, inicio_reserva, fin_reserva FROM comida WHERE id_comida = ?";
		RowMapper<Comida> rowMapper = new BeanPropertyRowMapper<Comida>(Comida.class);
		Comida comida = jdbcTemplate.queryForObject(sql, rowMapper, idComida);
		return comida;
	}

	@Override
	public List<Comida> getComida() {
		String sql = "select * from comida where dia=current_date order by id_comida asc";
		// RowMapper<Comida> rowMapper = new
		// BeanPropertyRowMapper<Comida>(Comida.class);
		RowMapper<Comida> rowMapper = new ComidaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);

	}

	@Override
	public List<Comida> getAllComidas() {
		String sql = "SELECT id_comida, nombre, descripcion, num_raciones, dia, comida_tipo, inicio_reserva, fin_reserva FROM comida";
		// RowMapper<Comida> rowMapper = new
		// BeanPropertyRowMapper<Comida>(Comida.class);
		RowMapper<Comida> rowMapper = new ComidaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Comida> getComidaIdByWeek(Date fecha) {
		String sql = "SELECT ms.* FROM menu_semana(?) ms order by id_comida asc";
		// RowMapper<Comida> rowMapper = new
		// BeanPropertyRowMapper<Comida>(Comida.class);
		RowMapper<Comida> rowMapper = new ComidaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, fecha);
	}

	@Override
	public List<Comida> getComidaIdByWeek() {
		String sql = "SELECT ms.* FROM menu_semana(current_date) ms order by id_comida asc";
		// RowMapper<Comida> rowMapper = new
		// BeanPropertyRowMapper<Comida>(Comida.class);
		RowMapper<Comida> rowMapper = new ComidaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int addComida(Comida comida) {
		// Add comida
		System.out.println("DAO 1\n");
		String sql = "SELECT * FROM insert_menu(?, ?, ?, ?)";
		System.out.println("DAO 2\n");
		return jdbcTemplate.queryForObject(sql,Integer.class, comida.getNombre(), comida.getDescripcion(), comida.getComidaTipo(),
				comida.getDia());
	}

	@Override
	public int addComida(AddComida addComida) {
		// Add comida
		String sql = "insert into comida (nombre, descripcion, dia, comida_tipo) values (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, addComida.getNombre(), addComida.getDescripcion(), addComida.getDia(),
				addComida.getComidaTipo());

	}

	@Override
	public int updateComida(Comida comida) {
		String sql = "UPDATE COMIDA SET nombre = ?, descripcion = ?, inicio_reserva = ?, fin_reserva = ? WHERE id_comida = ?";
		return jdbcTemplate.update(sql, comida.getNombre(), comida.getDescripcion(), comida.getInicioReserva(),
				comida.getFinReserva(), comida.getIdComida());

	}

	@Override
	public void deleteComida(int idComida) {
		String sql = "DELETE FROM comida WHERE id_comida = ?";
		jdbcTemplate.update(sql, idComida);
	}

}
