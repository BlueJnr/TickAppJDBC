package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.ISancionDAO;
import edu.calidadsw.entity.Sancion;
import edu.calidadsw.service.ISancionService;

@Service
public class SancionServiceImpl implements ISancionService {
	@Autowired
	private ISancionDAO sancionDAO;
	@Override
	public Sancion getSancionById(int idSancion) {
		Sancion obj = sancionDAO.getSancionById(idSancion);
		return obj;
	}	
	@Override
	public List<Sancion> getAllSancions(){
		return sancionDAO.getAllSancions();
	}
	@Override
	public Sancion addSancion(Sancion sancion){
                
		return sancionDAO.addSancion(sancion);

	}
	@Override
	public Sancion updateSancion(Sancion sancion) {
		return sancionDAO.updateSancion(sancion);
	}
	@Override
	public int aplicarSancion() {
		return sancionDAO.aplicarSancion();
	}
	@Override
	public int quitarSancion() {
		return sancionDAO.quitarSancion();
	}
	@Override
	public void deleteSancion(int idSancion) {
		sancionDAO.deleteSancion(idSancion);
	}

}
