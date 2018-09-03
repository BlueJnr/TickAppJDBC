package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.NivelTurno;

public interface INivelTurnoDAO {
    List<NivelTurno> getAllNivelTurnos();
    List<NivelTurno> getAllNivelTurnosByIdComida(int idComida);
    int getIdNivelTurnoByIdComidaNivelTurno(int idComida, int nivel, int turno);
    NivelTurno getNivelTurnoById(int idNivelTurno);
    int addNivelTurno(NivelTurno nivelTurno);
    int updateNivelTurno(NivelTurno nivelTurno);
    void deleteNivelTurno(int idNivelTurno);
}

