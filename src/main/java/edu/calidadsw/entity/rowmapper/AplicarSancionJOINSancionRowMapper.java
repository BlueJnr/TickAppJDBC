package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.AplicarSancionJOINSancion;
public class AplicarSancionJOINSancionRowMapper implements RowMapper<AplicarSancionJOINSancion> {
	@Override
	public AplicarSancionJOINSancion mapRow(ResultSet row, int rowNum) throws SQLException {
		AplicarSancionJOINSancion aplicarSancionJOINSancion = new AplicarSancionJOINSancion();
		aplicarSancionJOINSancion.setIdSancion(row.getInt("id_sancion"));
		aplicarSancionJOINSancion.setNombreSancion(row.getString("nombre_sancion"));
		aplicarSancionJOINSancion.setIdUsuario(row.getInt("id_usuario"));
		aplicarSancionJOINSancion.setInicio(row.getDate("inicio"));
		aplicarSancionJOINSancion.setFin(row.getDate("fin"));
		return aplicarSancionJOINSancion;
	}
}