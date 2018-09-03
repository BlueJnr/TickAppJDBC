package edu.calidadsw.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.calidadsw.dao.IComidaDAO;
import edu.calidadsw.entity.Comida;
import edu.calidadsw.model.json.AddComida;
import edu.calidadsw.service.IComidaService;

@Service
public class ComidaServiceImpl implements IComidaService {
	@Autowired
	private IComidaDAO comidaDAO;
	@Override
	public Comida getComidaById(int idComida) {
		Comida obj = comidaDAO.getComidaById(idComida);
		return obj;
	}
	@Override
	public List<Comida> getComida() {
		return comidaDAO.getComida();
	}
	@Override
	public int addComida(AddComida addComida) {
		return comidaDAO.addComida(addComida);
	}
	@Override
	public List<Comida> getAllComidas(){
		return comidaDAO.getAllComidas();
	}
	@Override
	public List<Comida> getComidaIdByWeek(Date fecha) {
		return comidaDAO.getComidaIdByWeek(fecha);
	}
	@Override
	public List<Comida> getComidaIdByWeek() {
		return comidaDAO.getComidaIdByWeek();
	}
	@Override
	public int addComida(Comida comida){               
		return comidaDAO.addComida(comida);
	}
	@Override
	public int addListComida(List<Comida> comidaList) {
		System.out.println("UNO\n");
		int add = 0;
		System.out.println("DOS\n");
		for (Comida comida : comidaList) {
			System.out.println("TRES\n");
			add = add + comidaDAO.addComida(comida);
			System.out.println("CUATRO\n");
		}
		System.out.println("CINCO\n");
		return add;
	}
	@Override
	public int updateComida(Comida comida) {
		return comidaDAO.updateComida(comida);
	}
	@Override
	public void deleteComida(int idComida) {
		comidaDAO.deleteComida(idComida);
	}

}
