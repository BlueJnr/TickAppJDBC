package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.IAplicarSancionDAO;
import edu.calidadsw.entity.AplicarSancion;
import edu.calidadsw.entity.rowmapper.AplicarSancionRowMapper;

@Transactional
@Repository
public class AplicarSancionDAOImpl implements IAplicarSancionDAO {
	@Autowired
        private JdbcTemplate jdbcTemplate;
	@Override
	public AplicarSancion getAplicarSancionById(int idAplicarSancion) {
		String sql = "SELECT id_aplica, inicio, fin, id_usuario, id_sancion FROM aplicar_sancion WHERE id_aplica = ?";
		RowMapper<AplicarSancion> rowMapper = new BeanPropertyRowMapper<AplicarSancion>(AplicarSancion.class);
		AplicarSancion aplicarSancion = jdbcTemplate.queryForObject(sql, rowMapper, idAplicarSancion);
		return aplicarSancion;
	}
	@Override
	public List<AplicarSancion> getAllAplicarSancions() {
		String sql = "SELECT id_aplica, inicio, fin, id_usuario, id_sancion FROM aplicar_sancion";
                //RowMapper<AplicarSancion> rowMapper = new BeanPropertyRowMapper<AplicarSancion>(AplicarSancion.class);
		RowMapper<AplicarSancion> rowMapper = new AplicarSancionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	@Override
	public AplicarSancion addAplicarSancion(AplicarSancion aplicarSancion) {
		//Add aplicarSancion
		String sql = "INSERT INTO aplicar_sancion (id_aplica, inicio, fin, id_usuario, id_sancion) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, aplicarSancion.getIdAplica(),
		aplicarSancion.getInicio(),
		aplicarSancion.getFin(),
		aplicarSancion.getIdUsuario(),
		aplicarSancion.getIdSancion());
		
		//Fetch aplicarSancion id
		sql = "SELECT id_aplica, inicio, fin, id_usuario, id_sancion FROM aplicar_sancion WHERE id_aplica = ?";
		AplicarSancion aplicarSancionNew = jdbcTemplate.queryForObject(sql, AplicarSancion.class, aplicarSancion.getIdAplica());
		
		//Set aplicarSancion id 
		return aplicarSancionNew;
	}
	@Override
	public AplicarSancion updateAplicarSancion(AplicarSancion aplicarSancion) {
		String sql = "UPDATE aplicar_sancion SET inicio = ?, fin = ?, id_usuario = ?, id_sancion = ? WHERE id_aplica = ?";
		jdbcTemplate.update(sql, aplicarSancion.getInicio(),
				aplicarSancion.getFin(),
				aplicarSancion.getIdUsuario(),
				aplicarSancion.getIdSancion(),aplicarSancion.getIdAplica());
		
		//Fetch aplicarSancion id
		sql = "SELECT id_aplica, inicio, fin, id_usuario, id_sancion FROM aplicar_sancion WHERE id_aplica = ?";
		AplicarSancion aplicarSancionUpdate = jdbcTemplate.queryForObject(sql, AplicarSancion.class, aplicarSancion.getIdAplica());
				
		//Set aplicarSancion id 
		return aplicarSancionUpdate;
	}
	@Override
	public void deleteAplicarSancion(int idAplicarSancion) {
		String sql = "DELETE FROM aplicar_sancion WHERE id_aplica = ?";
		jdbcTemplate.update(sql, idAplicarSancion);
	}

}