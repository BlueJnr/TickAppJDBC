package edu.calidadsw.dao;

import java.util.Date;
import java.util.List;

import edu.calidadsw.entity.Comida;
import edu.calidadsw.model.json.AddComida;

public interface IComidaDAO {
    List<Comida> getAllComidas();
    List<Comida> getComidaIdByWeek(Date fecha);
    List<Comida> getComidaIdByWeek();
    Comida getComidaById(int idComida);
    List<Comida> getComida();
    int addComida(Comida comida);
    int addComida(AddComida addComida);
    int updateComida(Comida comida);
    void deleteComida(int idComida);
}

