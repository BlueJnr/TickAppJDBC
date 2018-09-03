package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.NivelTurno;
public class NivelTurnoRowMapper implements RowMapper<NivelTurno> {
	@Override
	public NivelTurno mapRow(ResultSet row, int rowNum) throws SQLException {
		NivelTurno nivelTurno = new NivelTurno();
		nivelTurno.setIdNt(row.getInt("id_nt"));
		nivelTurno.setNivel(row.getInt("nivel"));
		nivelTurno.setTurno(row.getInt("turno"));
		nivelTurno.setHoraInicio(row.getTime("hora_inicio"));
		nivelTurno.setHoraFin(row.getTime("hora_fin"));
		nivelTurno.setNumTickets(row.getInt("num_tickets"));
		nivelTurno.setIdComida(row.getInt("id_comida"));
		return nivelTurno;
	}
} 
