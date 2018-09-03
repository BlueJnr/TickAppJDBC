package edu.calidadsw.dao;

import java.util.List;

import edu.calidadsw.entity.Usuario;

public interface IUsuarioDAO {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int idUsuario);
    Usuario getUsuarioByUusuarioPassword(String user, String password);
    Usuario addUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    void deleteUsuario(int idUsuario);
}
