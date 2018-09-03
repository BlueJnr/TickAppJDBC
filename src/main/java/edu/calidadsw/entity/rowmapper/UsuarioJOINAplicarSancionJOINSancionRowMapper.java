package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.UsuarioJOINAplicarSancionJOINSancion;
public class UsuarioJOINAplicarSancionJOINSancionRowMapper implements RowMapper<UsuarioJOINAplicarSancionJOINSancion> {
	@Override
	public UsuarioJOINAplicarSancionJOINSancion mapRow(ResultSet row, int rowNum) throws SQLException {
		UsuarioJOINAplicarSancionJOINSancion usuarioJOINAplicarSancionJOINSancion = new UsuarioJOINAplicarSancionJOINSancion();
		usuarioJOINAplicarSancionJOINSancion.setIdUsuario(row.getInt("id_usuario"));
		usuarioJOINAplicarSancionJOINSancion.setNombres(row.getString("nombres"));
		usuarioJOINAplicarSancionJOINSancion.setApePat(row.getString("ape_pat"));
		usuarioJOINAplicarSancionJOINSancion.setApeMat(row.getString("ape_mat"));
		usuarioJOINAplicarSancionJOINSancion.setCodigo(row.getString("codigo"));
		usuarioJOINAplicarSancionJOINSancion.setIdAplica(row.getInt("id_aplica"));
		usuarioJOINAplicarSancionJOINSancion.setInicio(row.getDate("inicio"));
		usuarioJOINAplicarSancionJOINSancion.setFin(row.getDate("fin"));
		usuarioJOINAplicarSancionJOINSancion.setIdSancion(row.getInt("id_sancion"));
		usuarioJOINAplicarSancionJOINSancion.setNombreSancion(row.getString("nombre_sancion"));
		return usuarioJOINAplicarSancionJOINSancion;
	}
}