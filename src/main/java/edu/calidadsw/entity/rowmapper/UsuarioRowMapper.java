package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.Usuario;
public class UsuarioRowMapper implements RowMapper<Usuario> {
	@Override
	public Usuario mapRow(ResultSet row, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(row.getInt("id_usuario"));
		usuario.setNombres(row.getString("nombres"));
		usuario.setApePat(row.getString("ape_pat"));
		usuario.setApeMat(row.getString("ape_mat"));
		usuario.setCodigo(row.getString("codigo"));
		usuario.setDni(row.getString("dni"));
		usuario.setUser(row.getString("_user"));
		usuario.setUser(row.getString("_password"));
		usuario.setTelefono(row.getString("telefono"));
		usuario.setEstado(row.getString("estado"));
		usuario.setIdTu(row.getInt("id_tu"));
		return usuario;
	}
} 