package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface GameManager {

    public void registrar(String username, String contraseña);

    public Usuario getUser(String username);

    //Funciones para testear:
    public int usuariosSize();
}
