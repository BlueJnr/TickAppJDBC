package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.IAccedeDAO;
import edu.calidadsw.entity.Accede;
import edu.calidadsw.model.json.UpdateAccesoComida;
import edu.calidadsw.service.IAccedeService;

@Service
public class AccedeServiceImpl implements IAccedeService {
	@Autowired
	private IAccedeDAO accedeDAO;
	@Override
	public Accede getAccedeById(int idAccede) {
		Accede obj = accedeDAO.getAccedeById(idAccede);
		return obj;
	}	
	@Override
	public List<Accede> getAllAccedes(){
		return accedeDAO.getAllAccedes();
	}
	public List<Accede> getAllAccedesByIdComida(int idComida) {
		return accedeDAO.getAllAccedesByIdComida(idComida);
	}
	@Override
	public Accede addAccede(Accede accede){               
		return accedeDAO.addAccede(accede);
	}
	@Override
	public int updateAccede(Accede accede) {
		return accedeDAO.updateAccede(accede);
	}
	@Override
	public int updateAccesoComida(UpdateAccesoComida updateAccesoComida) {
		return accedeDAO.updateAccesoComida(updateAccesoComida);
	}
	@Override
	public void deleteAccede(int idAccede) {
		accedeDAO.deleteAccede(idAccede);
	}

}
