package edu.calidadsw.service;

import java.util.List;

import edu.calidadsw.entity.AplicarSancionJOINSancion;
import edu.calidadsw.entity.UsuarioJOINAplicarSancionJOINSancion;

public interface IUsuarioJOINAplicarSancionJOINSancionService {
    List<UsuarioJOINAplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions();
    List<AplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions(int idUsuario);
}
