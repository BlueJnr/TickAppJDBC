package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.IAplicarSancionDAO;
import edu.calidadsw.entity.AplicarSancion;
import edu.calidadsw.service.IAplicarSancionService;

@Service
public class AplicarSancionServiceImpl implements IAplicarSancionService {
	@Autowired
	private IAplicarSancionDAO aplicarSancionDAO;
	@Override
	public AplicarSancion getAplicarSancionById(int idAplicarSancion) {
		AplicarSancion obj = aplicarSancionDAO.getAplicarSancionById(idAplicarSancion);
		return obj;
	}	
	@Override
	public List<AplicarSancion> getAllAplicarSancions(){
		return aplicarSancionDAO.getAllAplicarSancions();
	}
	@Override
	public AplicarSancion addAplicarSancion(AplicarSancion aplicarSancion){                
		return aplicarSancionDAO.addAplicarSancion(aplicarSancion);
	}
	@Override
	public AplicarSancion updateAplicarSancion(AplicarSancion aplicarSancion) {
		return aplicarSancionDAO.updateAplicarSancion(aplicarSancion);
	}
	@Override
	public void deleteAplicarSancion(int idAplicarSancion) {
		aplicarSancionDAO.deleteAplicarSancion(idAplicarSancion);
	}
}
