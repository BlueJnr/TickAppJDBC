package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.TipoUsuario;

public interface ITipoUsuarioDAO {
    List<TipoUsuario> getAllTipoUsuarios();
    TipoUsuario getTipoUsuarioById(int idTipoUsuario);
    TipoUsuario addTipoUsuario(TipoUsuario tipoUsuario);
    TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario);
    void deleteTipoUsuario(int idTipoUsuario);
}
