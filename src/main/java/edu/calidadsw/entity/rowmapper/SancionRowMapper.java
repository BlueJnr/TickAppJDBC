package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.Sancion;
public class SancionRowMapper implements RowMapper<Sancion> {
	@Override
	public Sancion mapRow(ResultSet row, int rowNum) throws SQLException {
		Sancion sancion = new Sancion();
		sancion.setIdSancion(row.getInt("id_sancion"));
		sancion.setNombreSancion(row.getString("nombre_sancion"));
		sancion.setDuracion(row.getInt("duracion"));
		return sancion;
	}
} 
