package edu.calidadsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.INivelTurnoDAO;
import edu.calidadsw.entity.NivelTurno;
import edu.calidadsw.service.INivelTurnoService;

@Service
public class NivelTurnoServiceImpl implements INivelTurnoService {
	@Autowired
	private INivelTurnoDAO nivelTurnoDAO;
	@Override
	public NivelTurno getNivelTurnoById(int idNivelTurno) {
		NivelTurno obj = nivelTurnoDAO.getNivelTurnoById(idNivelTurno);
		return obj;
	}	
	@Override
	public List<NivelTurno> getAllNivelTurnos(){
		return nivelTurnoDAO.getAllNivelTurnos();
	}
	@Override
	public int getIdNivelTurnoByIdComidaNivelTurno(int idComida, int nivel, int turno) {
		return nivelTurnoDAO.getIdNivelTurnoByIdComidaNivelTurno(idComida, nivel, turno);
	}
	@Override
	public List<NivelTurno> getAllNivelTurnosByIdComida(int idComida) {
		return nivelTurnoDAO.getAllNivelTurnosByIdComida(idComida);
	}
	@Override
	public int addNivelTurno(NivelTurno nivelTurno){       
		return nivelTurnoDAO.addNivelTurno(nivelTurno);
	}
	@Override
	public int updateNivelTurno(NivelTurno nivelTurno) {
		return nivelTurnoDAO.updateNivelTurno(nivelTurno);
	}
	@Override
	public int updateNivelTurno(List<NivelTurno> nivelTurnoList) {
		int update=0;
		for (NivelTurno nivelTurno : nivelTurnoList) {
			update=update+nivelTurnoDAO.updateNivelTurno(nivelTurno);
		}
		return update;
	}
	@Override
	public void deleteNivelTurno(int idNivelTurno) {
		nivelTurnoDAO.deleteNivelTurno(idNivelTurno);
	}


}
