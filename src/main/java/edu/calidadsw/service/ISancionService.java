package edu.calidadsw.service;

import java.util.List;

import edu.calidadsw.entity.Sancion;

public interface ISancionService {
    List<Sancion> getAllSancions();
    Sancion getSancionById(int idSancion);
    Sancion addSancion(Sancion sancion);
    Sancion updateSancion(Sancion sancion);
    int aplicarSancion();
    int quitarSancion();
    void deleteSancion(int idSancion);
}
