package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.AplicarSancionJOINSancion;
import edu.calidadsw.entity.UsuarioJOINAplicarSancionJOINSancion;

public interface IUsuarioJOINAplicarSancionJOINSancionDAO {
    List<UsuarioJOINAplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions();
    List<AplicarSancionJOINSancion> getAllUsuarioJOINAplicarSancionJOINSancions(int idUsuario);
}

