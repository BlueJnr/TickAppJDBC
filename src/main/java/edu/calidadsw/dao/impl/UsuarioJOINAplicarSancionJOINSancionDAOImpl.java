package edu.calidadsw.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.calidadsw.dao.IUsuarioJOINAplicarSancionJOINSancionDAO;
import edu.calidadsw.entity.AplicarSancionJOINSancion;
import edu.calidadsw.entity.UsuarioJOINAplicarSancionJOINSancion;
import edu.calidadsw.entity.rowmapper.AplicarSancionJOINSancionRowMapper;
import edu.calidadsw.entity.rowmapper.UsuarioJOINAplicarSancionJOINSancionRowMapper;

@Transactional
@Repository
public class UsuarioJOINAplicarSancionJOINSancionDAOImpl implements IUsuarioJOINAplicarSancionJOINSancionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UsuarioJOINAplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions() {
		String sql = "select u.id_usuario, u.nombres, u.ape_pat, u.ape_mat, u.codigo, aps.id_aplica, aps.inicio, aps.fin, s.id_sancion, s.nombre_sancion from aplicar_sancion aps, usuario u, sancion s where aps.id_usuario = u.id_usuario and aps.id_sancion = s.id_sancion";
		// RowMapper<UsuarioJOINAplicarSancionJOINSancion> rowMapper = new
		// BeanPropertyRowMapper<UsuarioJOINAplicarSancionJOINSancion>(UsuarioJOINAplicarSancionJOINSancion.class);
		RowMapper<UsuarioJOINAplicarSancionJOINSancion> rowMapper = new UsuarioJOINAplicarSancionJOINSancionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<AplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions(int idUsuario) {
		String sql = "SELECT SAN.id_sancion, SAN.nombre_sancion, APS.id_usuario, APS.inicio, APS.fin FROM APLICAR_SANCION APS, SANCION SAN WHERE APS.id_usuario = ? AND APS.id_sancion = SAN.id_sancion";
		// RowMapper<UsuarioJOINAplicarSancionJOINSancion> rowMapper = new
		// BeanPropertyRowMapper<UsuarioJOINAplicarSancionJOINSancion>(UsuarioJOINAplicarSancionJOINSancion.class);
		RowMapper<AplicarSancionJOINSancion> rowMapper = new AplicarSancionJOINSancionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, idUsuario);
	}

}