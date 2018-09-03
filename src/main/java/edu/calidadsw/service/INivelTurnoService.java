package edu.calidadsw.service;

import java.util.List;

import edu.calidadsw.entity.NivelTurno;

public interface INivelTurnoService {
    List<NivelTurno> getAllNivelTurnos();
    List<NivelTurno> getAllNivelTurnosByIdComida(int idComida);
    int getIdNivelTurnoByIdComidaNivelTurno(int idComida, int nivel, int turno);
    NivelTurno getNivelTurnoById(int idNivelTurno);
    int addNivelTurno(NivelTurno nivelTurno);
    int updateNivelTurno(NivelTurno nivelTurno);
    int updateNivelTurno(List<NivelTurno> nivelTurnoList);
    void deleteNivelTurno(int idNivelTurno);
}
