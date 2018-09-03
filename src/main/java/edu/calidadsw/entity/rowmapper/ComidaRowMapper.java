package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.Comida;
public class ComidaRowMapper implements RowMapper<Comida> {
	@Override
	public Comida mapRow(ResultSet row, int rowNum) throws SQLException {
		Comida comida = new Comida();
		comida.setIdComida(row.getInt("id_comida"));
		comida.setNombre(row.getString("nombre"));
		comida.setDescripcion(row.getString("descripcion"));
		comida.setNumRaciones(row.getInt("num_raciones"));
		comida.setDia(row.getDate("dia"));
		comida.setComidaTipo(row.getString("comida_tipo"));
		comida.setInicioReserva(row.getTime("inicio_reserva"));
		comida.setFinReserva(row.getTime("fin_reserva"));
		return comida;
	}
} 
