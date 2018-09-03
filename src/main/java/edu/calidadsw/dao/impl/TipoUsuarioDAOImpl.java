package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.ITipoUsuarioDAO;
import edu.calidadsw.entity.TipoUsuario;
import edu.calidadsw.entity.rowmapper.TipoUsuarioRowMapper;

@Transactional
@Repository
public class TipoUsuarioDAOImpl implements ITipoUsuarioDAO {
	@Autowired
        private JdbcTemplate jdbcTemplate;
	@Override
	public TipoUsuario getTipoUsuarioById(int idTipoUsuario) {
		String sql = "SELECT id_tu, nombre_tu FROM tipo_usuario WHERE id_tu = ?";
		RowMapper<TipoUsuario> rowMapper = new BeanPropertyRowMapper<TipoUsuario>(TipoUsuario.class);
		TipoUsuario tipoUsuario = jdbcTemplate.queryForObject(sql, rowMapper, idTipoUsuario);
		return tipoUsuario;
	}
	@Override
	public List<TipoUsuario> getAllTipoUsuarios() {
		String sql = "SELECT id_tu, nombre_tu FROM tipo_usuario";
                //RowMapper<TipoUsuario> rowMapper = new BeanPropertyRowMapper<TipoUsuario>(TipoUsuario.class);
		RowMapper<TipoUsuario> rowMapper = new TipoUsuarioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	@Override
	public TipoUsuario addTipoUsuario(TipoUsuario tipoUsuario) {
		//Add tipoUsuario
		String sql = "INSERT INTO tipo_usuario (id_tu, nombre_tu) values (?, ?)";
		jdbcTemplate.update(sql, tipoUsuario.getIdTu(),
		tipoUsuario.getNombreTu());
		
		//Fetch tipoUsuario id
		sql = "SELECT id_tu, nombre_tu FROM tipo_usuario WHERE id_tu = ?";
		TipoUsuario tipoUsuarioNew = jdbcTemplate.queryForObject(sql, TipoUsuario.class, tipoUsuario.getIdTu());
		
		//Set tipoUsuario id 
		return tipoUsuarioNew;
	}
	@Override
	public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario) {
		String sql = "UPDATE nombre_tu = ? WHERE id_tu = ?";
		jdbcTemplate.update(sql,tipoUsuario.getNombreTu(), tipoUsuario.getIdTu());
		
		//Fetch tipoUsuario id
		sql = "SELECT id_tu, nombre_tu FROM tipo_usuario WHERE id_tu = ?";
		TipoUsuario tipoUsuarioUpdate = jdbcTemplate.queryForObject(sql, TipoUsuario.class, tipoUsuario.getIdTu());
				
		//Set tipoUsuario id 
		return tipoUsuarioUpdate;
	}
	@Override
	public void deleteTipoUsuario(int idTipoUsuario) {
		String sql = "DELETE FROM tipo_usuario WHERE id_tu = ?";
		jdbcTemplate.update(sql, idTipoUsuario);
	}

}