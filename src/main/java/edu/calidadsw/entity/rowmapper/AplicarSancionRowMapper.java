package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.AplicarSancion;
public class AplicarSancionRowMapper implements RowMapper<AplicarSancion> {
	@Override
	public AplicarSancion mapRow(ResultSet row, int rowNum) throws SQLException {
		AplicarSancion aplicarSancion = new AplicarSancion();
		aplicarSancion.setIdAplica(row.getInt("id_aplica"));
		aplicarSancion.setInicio(row.getDate("inicio"));
		aplicarSancion.setFin(row.getDate("fin"));
		aplicarSancion.setIdUsuario(row.getInt("id_usuario"));
		aplicarSancion.setIdSancion(row.getInt("id_sancion"));
		return aplicarSancion;
	}
} 
