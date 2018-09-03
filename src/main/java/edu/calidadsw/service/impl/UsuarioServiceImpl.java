package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.IUsuarioDAO;
import edu.calidadsw.entity.Usuario;
import edu.calidadsw.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDAO usuarioDAO;
	@Override
	public Usuario getUsuarioById(int idUsuario) {
		Usuario obj = usuarioDAO.getUsuarioById(idUsuario);
		return obj;
	}
	@Override
	public Usuario getUsuarioByUusuarioPassword(String user, String password) {
		Usuario obj = usuarioDAO.getUsuarioByUusuarioPassword(user,password);
		return obj;
	}
	@Override
	public List<Usuario> getAllUsuarios(){
		return usuarioDAO.getAllUsuarios();
	}
	@Override
	public Usuario addUsuario(Usuario usuario){
                
		return usuarioDAO.addUsuario(usuario);

	}
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDAO.updateUsuario(usuario);
	}
	@Override
	public void deleteUsuario(int idUsuario) {
		usuarioDAO.deleteUsuario(idUsuario);
	}

}