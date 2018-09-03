package edu.calidadsw.service;

import java.util.List;

import edu.calidadsw.entity.Usuario;

public interface IUsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int idUsuario);
    Usuario getUsuarioByUusuarioPassword(String user, String password);
    Usuario addUsuario(Usuario usuario);
    Usuario updateUsuario(Usuario usuario);
    void deleteUsuario(int idUsuario);
}
