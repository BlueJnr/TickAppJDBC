package edu.calidadsw.service;

import java.util.Date;
import java.util.List;

import edu.calidadsw.entity.Comida;
import edu.calidadsw.model.json.AddComida;

public interface IComidaService {
    List<Comida> getAllComidas();
    List<Comida> getComidaIdByWeek(Date fecha);
    List<Comida> getComidaIdByWeek();
    Comida getComidaById(int idComida);
    List<Comida> getComida();
    int addComida(Comida comida);
    int addListComida(List<Comida> comidaList);
    int addComida(AddComida addComida);
    int updateComida(Comida comida);
    void deleteComida(int idComida);
}
