package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.Accede;
public class AccedeRowMapper implements RowMapper<Accede> {
	@Override
	public Accede mapRow(ResultSet row, int rowNum) throws SQLException {
		Accede accede = new Accede();
		accede.setIdAccede(row.getInt("id_accede"));
		accede.setIdComida(row.getInt("id_comida"));
		accede.setIdTu(row.getInt("id_tu"));
		return accede;
	}
} 