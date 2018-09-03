package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.IUsuarioJOINAplicarSancionJOINSancionDAO;
import edu.calidadsw.entity.AplicarSancionJOINSancion;
import edu.calidadsw.entity.UsuarioJOINAplicarSancionJOINSancion;
import edu.calidadsw.service.IUsuarioJOINAplicarSancionJOINSancionService;

@Service
public class UsuarioJOINAplicarSancionJOINSancionServiceImpl implements IUsuarioJOINAplicarSancionJOINSancionService {
	@Autowired
	private IUsuarioJOINAplicarSancionJOINSancionDAO usuarioDAO;

	@Override
	public List<UsuarioJOINAplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions(){
		return usuarioDAO.getAllUsuarioJOINAplicarSancionJOINSancions();
	}

	@Override
	public List<AplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions(int idUsuario) {
		return usuarioDAO.getAllUsuarioJOINAplicarSancionJOINSancions(idUsuario);
	}

}