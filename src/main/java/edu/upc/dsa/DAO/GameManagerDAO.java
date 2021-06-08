package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface GameManagerDAO {

    public void registrar(String username, String contraseña, String email);

    public Usuario logIn(String username, String password);

    public Usuario getUser(String username);

    List<Usuario> getSortedUsersList();

    public int borrarUsuario(String username);

    //Funciones para testear:
    public int usuariosSize();

}
