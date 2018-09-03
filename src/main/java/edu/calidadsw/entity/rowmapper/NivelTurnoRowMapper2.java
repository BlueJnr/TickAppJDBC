package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.NivelTurno2;
public class NivelTurnoRowMapper2 implements RowMapper<NivelTurno2> {
	@Override
	public NivelTurno2 mapRow(ResultSet row, int rowNum) throws SQLException {
		NivelTurno2 nivelTurno2 = new NivelTurno2();
		nivelTurno2.setNivel(row.getInt("nivel"));
		nivelTurno2.setTurno(row.getInt("turno"));
		return nivelTurno2;
	}
} 
