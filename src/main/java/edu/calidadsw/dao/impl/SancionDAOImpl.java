package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.ISancionDAO;
import edu.calidadsw.entity.Sancion;
import edu.calidadsw.entity.rowmapper.SancionRowMapper;

@Transactional
@Repository
public class SancionDAOImpl implements ISancionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Sancion getSancionById(int idSancion) {
		String sql = "SELECT id_sancion, nombre_sancion, duracion FROM sancion WHERE id_sancion = ?";
		RowMapper<Sancion> rowMapper = new BeanPropertyRowMapper<Sancion>(Sancion.class);
		Sancion sancion = jdbcTemplate.queryForObject(sql, rowMapper, idSancion);
		return sancion;
	}

	@Override
	public List<Sancion> getAllSancions() {
		String sql = "SELECT id_sancion, nombre_sancion, duracion FROM sancion";
		// RowMapper<Sancion> rowMapper = new
		// BeanPropertyRowMapper<Sancion>(Sancion.class);
		RowMapper<Sancion> rowMapper = new SancionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Sancion addSancion(Sancion sancion) {
		// Add sancion
		String sql = "INSERT INTO sancion (id_sancion, nombre_sancion, duracion) values (?, ?, ?)";
		jdbcTemplate.update(sql, sancion.getIdSancion(), sancion.getNombreSancion(), sancion.getDuracion());

		// Fetch sancion id
		sql = "SELECT  = ? FROM sancion WHERE id_sancion = ?";
		Sancion sancionNew = jdbcTemplate.queryForObject(sql, Sancion.class, sancion.getIdSancion());

		// Set sancion id
		return sancionNew;
	}

	@Override
	public Sancion updateSancion(Sancion sancion) {
		String sql = "UPDATE sancion SET id_sancion = ?, nombre_sancion = ?, duracion = ? WHERE id_sancion = ?";
		jdbcTemplate.update(sql, sancion.getNombreSancion(), sancion.getDuracion(), sancion.getIdSancion());

		// Fetch sancion id
		sql = "SELECT id_sancion, nombre_sancion, duracion FROM sancion WHERE id_sancion = ?";
		Sancion sancionUpdate = jdbcTemplate.queryForObject(sql, Sancion.class, sancion.getIdSancion());

		// Set sancion id
		return sancionUpdate;
	}

	@Override
	public int aplicarSancion() {
		String sql = "select * from aplica_sancion()";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int quitarSancion() {
		String sql = "select * from quitar_sancion()";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void deleteSancion(int idSancion) {
		String sql = "DELETE FROM sancion WHERE id_sancion = ?";
		jdbcTemplate.update(sql, idSancion);
	}

}
