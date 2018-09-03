package edu.calidadsw.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.calidadsw.entity.UsuarioJOINTicketJOINNivelTurno;
public class UsuarioJOINTicketJOINNivelTurnoRowMapper implements RowMapper<UsuarioJOINTicketJOINNivelTurno> {
	@Override
	public UsuarioJOINTicketJOINNivelTurno mapRow(ResultSet row, int rowNum) throws SQLException {
		UsuarioJOINTicketJOINNivelTurno usuarioJOINTicketJOINNivelTurno = new UsuarioJOINTicketJOINNivelTurno();
		usuarioJOINTicketJOINNivelTurno.setIdUsuario(row.getInt("id_usuario"));
		usuarioJOINTicketJOINNivelTurno.setNombres(row.getString("nombres"));
		usuarioJOINTicketJOINNivelTurno.setApePat(row.getString("ape_pat"));
		usuarioJOINTicketJOINNivelTurno.setApeMat(row.getString("ape_mat"));
		usuarioJOINTicketJOINNivelTurno.setCodigo(row.getString("codigo"));
		usuarioJOINTicketJOINNivelTurno.setUser(row.getString("_user"));
		usuarioJOINTicketJOINNivelTurno.setIdTicket(row.getInt("id_ticket"));
		usuarioJOINTicketJOINNivelTurno.setNumero(row.getInt("numero"));
		usuarioJOINTicketJOINNivelTurno.setEstado(row.getString("estado"));
		usuarioJOINTicketJOINNivelTurno.setIdNt(row.getInt("id_nt"));
		usuarioJOINTicketJOINNivelTurno.setNivel(row.getInt("nivel"));
		usuarioJOINTicketJOINNivelTurno.setTurno(row.getInt("turno"));
		return usuarioJOINTicketJOINNivelTurno;
	}
}
