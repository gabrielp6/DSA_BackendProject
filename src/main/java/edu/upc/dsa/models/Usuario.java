package edu.upc.dsa.models;

import java.util.List;

public class Usuario {

    String username;
    String contraseña;
    String email;
    int idUsuario;
    int monedas;

    List<Objeto> listaObjetos;
    List<Partida> listaPartidas;


    public Usuario() {
    }


    public Usuario(String username, String contraseña, String email) {
        this.username = username;
        this.contraseña = contraseña;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }
}
