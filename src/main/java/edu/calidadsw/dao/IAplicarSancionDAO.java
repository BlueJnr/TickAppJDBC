package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.AplicarSancion;

public interface IAplicarSancionDAO {
    List<AplicarSancion> getAllAplicarSancions();
    AplicarSancion getAplicarSancionById(int idAplicarSancion);
    AplicarSancion addAplicarSancion(AplicarSancion aplicarSancion);
    AplicarSancion updateAplicarSancion(AplicarSancion aplicarSancion);
    void deleteAplicarSancion(int idAplicarSancion);
}
