package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.IUsuarioDAO;
import edu.calidadsw.entity.Usuario;
import edu.calidadsw.entity.rowmapper.UsuarioRowMapper;

@Transactional
@Repository
public class UsuarioDAOImpl implements IUsuarioDAO {
	@Autowired
        private JdbcTemplate jdbcTemplate;
	@Override
	public Usuario getUsuarioById(int idUsuario) {
		String sql = "SELECT id_usuario, nombres, ape_pat, ape_mat, codigo, dni, _user, _password, telefono, estado, id_tu FROM usuario WHERE id_usuario = ?";
		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario usuario = jdbcTemplate.queryForObject(sql, rowMapper, idUsuario);
		return usuario;
	}
	
	@Override
	public Usuario getUsuarioByUusuarioPassword(String user, String password) {
		String sql = "SELECT id_usuario, nombres, ape_pat, ape_mat, codigo, dni, _user, _password, telefono, estado, id_tu FROM usuario WHERE _user = ? and _password = ?";
		RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario usuario = jdbcTemplate.queryForObject(sql, rowMapper, user, password);
		return usuario;
	}
	
	@Override
	public List<Usuario> getAllUsuarios() {
		String sql = "SELECT id_usuario, nombres, ape_pat, ape_mat, codigo, dni, _user, _password, telefono, estado, id_tu FROM usuario";
                //RowMapper<Usuario> rowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		RowMapper<Usuario> rowMapper = new UsuarioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	@Override
	public Usuario addUsuario(Usuario usuario) {
		//Add usuario
		String sql = "INSERT INTO usuario (id_usuario, nombres, ape_pat, ape_mat, codigo, dni, _user, _password, telefono, estado, id_tu) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,usuario.getIdUsuario(),
		usuario.getNombres(),
		usuario.getApePat(),
		usuario.getApeMat(),
		usuario.getCodigo(),
		usuario.getDni(),
		usuario.getUser(),
		usuario.getUser(),
		usuario.getTelefono(),
		usuario.getEstado(),
		usuario.getIdTu());
		
		//Fetch usuario id
		sql = "SELECT id_usuario, nombres, ape_pat, ape_mat, codigo, dni, _user, _password, telefono, estado, id_tu FROM usuario WHERE id_tu = ?";
		Usuario usuarioNew = jdbcTemplate.queryForObject(sql, Usuario.class, usuario.getIdTu());
		
		//Set usuario id 
		return usuarioNew;
	}
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		String sql = "UPDATE id_usuario = ?, nombres = ?, ape_pat = ?, ape_mat = ?, codigo = ?, dni = ?, _user = ?, _password = ?, telefono = ?, estado = ?, id_tu = ? WHERE id_usuario = ?";
		jdbcTemplate.update(sql,usuario.getNombres(),
				usuario.getApePat(),
				usuario.getApeMat(),
				usuario.getCodigo(),
				usuario.getDni(),
				usuario.getUser(),
				usuario.getUser(),
				usuario.getTelefono(),
				usuario.getEstado(),
				usuario.getIdTu(), usuario.getIdUsuario());
		
		//Fetch usuario id
		sql = "SELECT id_usuario, nombres, ape_pat, ape_mat, codigo, dni, _user, _password, telefono, estado, id_tu FROM usuario WHERE id_usuario = ?";
		Usuario usuarioUpdate = jdbcTemplate.queryForObject(sql, Usuario.class, usuario.getIdTu());
				
		//Set usuario id 
		return usuarioUpdate;
	}
	@Override
	public void deleteUsuario(int idUsuario) {
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
		jdbcTemplate.update(sql, idUsuario);
	}


}