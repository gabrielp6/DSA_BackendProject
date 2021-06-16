package edu.upc.dsa.models;

public class CredentialsPartida {

    String username;
    int enemigosMatados;
    int tiempo;
    int monedasRecogidas;

    public CredentialsPartida(){

    }

    public CredentialsPartida(String username, int enemigosMatados, int tiempo, int monedasRecogidas) {
        this.username = username;
        this.enemigosMatados = enemigosMatados;
        this.tiempo = tiempo;
        this.monedasRecogidas = monedasRecogidas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEnemigosMatados() {
        return enemigosMatados;
    }

    public void setEnemigosMatados(int enemigosMatados) {
        this.enemigosMatados = enemigosMatados;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getMonedasRecogidas() {
        return monedasRecogidas;
    }

    public void setMonedasRecogidas(int monedasRecogidas) {
        this.monedasRecogidas = monedasRecogidas;
    }

    @Override
    public String toString() {
        return "CredentialsPartida{" +
                "username='" + username + '\'' +
                ", enemigosMatados=" + enemigosMatados +
                ", tiempo=" + tiempo +
                ", monedasRecogidas=" + monedasRecogidas +
                '}';
    }
}
