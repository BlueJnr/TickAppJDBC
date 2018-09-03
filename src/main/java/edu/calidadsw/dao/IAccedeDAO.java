package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.Accede;
import edu.calidadsw.model.json.UpdateAccesoComida;

public interface IAccedeDAO {
    List<Accede> getAllAccedes();
    List<Accede> getAllAccedesByIdComida(int idComida);
    Accede getAccedeById(int idAccede);
    Accede addAccede(Accede accede);
    int updateAccede(Accede accede);
    int updateAccesoComida(UpdateAccesoComida updateAccesoComida);
    void deleteAccede(int idAccede);
} 