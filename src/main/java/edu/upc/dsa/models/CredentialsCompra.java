package edu.upc.dsa.models;

public class CredentialsCompra {

    String nombreObjeto;
    String username;

    public CredentialsCompra() {
    }

    public CredentialsCompra(String nombreObjeto, String username) {
        this.nombreObjeto = nombreObjeto;
        this.username = username;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
