package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Partida {

    String idPartida;
    String username;
    int enemigosMatados;
    int tiempo;
    int monedasRecogidas;
    int puntuacionFinal;

    public Partida() {
    }

    public Partida(String username, int enemigosMatados, int tiempo, int monedasRecogidas) {
        this.idPartida = RandomUtils.getId();
        this.username = username;
        this.enemigosMatados = enemigosMatados;
        this.tiempo = tiempo;
        this.monedasRecogidas = monedasRecogidas;
        //EJEMPLO!!! :
        this.puntuacionFinal = enemigosMatados*10 + monedasRecogidas*5 + (1000-tiempo);
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
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

    public int getPuntuacionFinal() {
        return puntuacionFinal;
    }

    public void setPuntuacionFinal(int puntuacionFinal) {
        this.puntuacionFinal = puntuacionFinal;
    }
}
