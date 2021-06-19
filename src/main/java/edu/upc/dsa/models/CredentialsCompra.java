package edu.upc.dsa.models;

public class CredentialsCompra {

    String nombreObjeto;
    String username;
    int monedasActualizadas;

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

    public int getMonedasActualizadas() {
        return monedasActualizadas;
    }

    public void setMonedasActualizadas(int monedasActualizadas) {
        this.monedasActualizadas = monedasActualizadas;
    }
}
