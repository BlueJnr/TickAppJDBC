package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.ITipoUsuarioDAO;
import edu.calidadsw.entity.TipoUsuario;
import edu.calidadsw.service.ITipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements ITipoUsuarioService {
	@Autowired
	private ITipoUsuarioDAO tipoUsuarioDAO;
	@Override
	public TipoUsuario getTipoUsuarioById(int idTipoUsuario) {
		TipoUsuario obj = tipoUsuarioDAO.getTipoUsuarioById(idTipoUsuario);
		return obj;
	}	
	@Override
	public List<TipoUsuario> getAllTipoUsuarios(){
		return tipoUsuarioDAO.getAllTipoUsuarios();
	}
	@Override
	public TipoUsuario addTipoUsuario(TipoUsuario tipoUsuario){
                
		return tipoUsuarioDAO.addTipoUsuario(tipoUsuario);

	}
	@Override
	public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario) {
		return tipoUsuarioDAO.updateTipoUsuario(tipoUsuario);
	}
	@Override
	public void deleteTipoUsuario(int idTipoUsuario) {
		tipoUsuarioDAO.deleteTipoUsuario(idTipoUsuario);
	}
}
