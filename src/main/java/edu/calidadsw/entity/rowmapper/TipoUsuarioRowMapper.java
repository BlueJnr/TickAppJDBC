package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.TipoUsuario;
public class TipoUsuarioRowMapper implements RowMapper<TipoUsuario> {
	@Override
	public TipoUsuario mapRow(ResultSet row, int rowNum) throws SQLException {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTu(row.getInt("id_tu"));
		tipoUsuario.setNombreTu(row.getString("nombre_tu"));
		return tipoUsuario;
	}
} 