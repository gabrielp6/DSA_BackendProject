package edu.upc.dsa.models;

public class RecordUsuario {

    int idPartida;
    String username;
    int enemigosMatados;
    int tiempo;
    int monedasRecogidas;
    int puntuacionFinal;

    public RecordUsuario() {
    }

    public RecordUsuario(int idPartida, String username, int enemigosMatados, int tiempo, int monedasRecogidas, int puntuacionFinal) {
        this.idPartida = idPartida;
        this.username = username;
        this.enemigosMatados = enemigosMatados;
        this.tiempo = tiempo;
        this.monedasRecogidas = monedasRecogidas;
        this.puntuacionFinal = puntuacionFinal;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
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
