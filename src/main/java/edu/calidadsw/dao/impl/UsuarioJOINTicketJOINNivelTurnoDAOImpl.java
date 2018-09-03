package edu.calidadsw.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.IUsuarioJOINTicketJOINNivelTurnoDAO;
import edu.calidadsw.entity.UsuarioJOINTicketJOINNivelTurno;

@Transactional
@Repository
public class UsuarioJOINTicketJOINNivelTurnoDAOImpl implements IUsuarioJOINTicketJOINNivelTurnoDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public UsuarioJOINTicketJOINNivelTurno getUsuarioJOINTicketJOINNivelTurnoById(String codigo, String comidaTipo) {
		String sql = "SELECT US.id_usuario, US.nombres, US.ape_pat, US.ape_mat, US.codigo, US._user,TI.id_ticket, TI.numero, TI.estado, NT.id_nt, NT.nivel, NT.turno FROM USUARIO US, TICKET TI, COMIDA CO, NIVEL_TURNO NT WHERE US.codigo = ? AND TI.id_usuario = US.id_usuario AND TI.id_comida = CO.id_comida AND CO.dia = dia_servidor() AND CO.comida_tipo = ? AND TI.id_nt = NT.id_nt";
		RowMapper<UsuarioJOINTicketJOINNivelTurno> rowMapper = new BeanPropertyRowMapper<UsuarioJOINTicketJOINNivelTurno>(UsuarioJOINTicketJOINNivelTurno.class);
		UsuarioJOINTicketJOINNivelTurno usuarioJOINTicketJOINNivelTurno = jdbcTemplate.queryForObject(sql, rowMapper, codigo,comidaTipo);
		return usuarioJOINTicketJOINNivelTurno;

	}

}
