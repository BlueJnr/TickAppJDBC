package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.Sancion;

public interface ISancionDAO {
    List<Sancion> getAllSancions();
    Sancion getSancionById(int idSancion);
    Sancion addSancion(Sancion sancion);
    Sancion updateSancion(Sancion sancion);
    int aplicarSancion();
    int quitarSancion();
    void deleteSancion(int idSancion);
}


