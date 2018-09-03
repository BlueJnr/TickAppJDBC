package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.IAccedeDAO;
import edu.calidadsw.entity.Accede;
import edu.calidadsw.entity.rowmapper.AccedeRowMapper;
import edu.calidadsw.model.json.UpdateAccesoComida;

@Transactional
@Repository
public class AccedeDAOImpl implements IAccedeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Accede getAccedeById(int idAccede) {
		String sql = "SELECT id_accede, id_comida, id_tu FROM accede WHERE id_accede = ?";
		RowMapper<Accede> rowMapper = new BeanPropertyRowMapper<Accede>(Accede.class);
		Accede accede = jdbcTemplate.queryForObject(sql, rowMapper, idAccede);
		return accede;
	}

	@Override
	public List<Accede> getAllAccedes() {
		String sql = "SELECT id_accede, id_comida, id_tu FROM accede";
		// RowMapper<Accede> rowMapper = new
		// BeanPropertyRowMapper<Accede>(Accede.class);
		RowMapper<Accede> rowMapper = new AccedeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Accede> getAllAccedesByIdComida(int idComida) {
		String sql = "SELECT id_accede, id_comida, id_tu FROM accede WHERE id_comida = ?";
		// RowMapper<Accede> rowMapper = new
		// BeanPropertyRowMapper<Accede>(Accede.class);
		RowMapper<Accede> rowMapper = new AccedeRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, idComida);
	}

	@Override
	public Accede addAccede(Accede accede) {
		// Add accede
		String sql = "INSERT INTO accede (id_accede, id_comida, id_tu) values (?, ?, ?)";
		jdbcTemplate.update(sql, accede.getIdAccede(), accede.getIdComida(), accede.getIdTu());

		// Fetch accede id
		sql = "SELECT id_accede, id_comida, id_tu FROM accede WHERE id_accede = ?";
		Accede accedeNew = jdbcTemplate.queryForObject(sql, Accede.class, accede.getIdAccede());

		// Set accede id
		return accedeNew;
	}

	@Override
	public int updateAccede(Accede accede) {
		String sql = "UPDATE accede SET id_comida = ?, id_tu = ? WHERE id_accede = ?";
		return jdbcTemplate.update(sql, accede.getIdComida(), accede.getIdTu(), accede.getIdAccede());

	}
	

	@Override
	public int updateAccesoComida(UpdateAccesoComida updateAccesoComida) {
		String sql = "SELECT * FROM ACTUALIZAR_ACCESO_COMIDA(?, ?, ?, ?) as actualizar";
		// RowMapper<Accede> rowMapper = new
		// BeanPropertyRowMapper<Accede>(Accede.class);
		return jdbcTemplate.queryForObject(sql,Integer.class, updateAccesoComida.getIdComida(), updateAccesoComida.getProfesor(), updateAccesoComida.getAlumno(), updateAccesoComida.getResidente());
	}

	@Override
	public void deleteAccede(int idAccede) {
		String sql = "DELETE FROM accede WHERE id_accede = ?";
		jdbcTemplate.update(sql, idAccede);
	}

}