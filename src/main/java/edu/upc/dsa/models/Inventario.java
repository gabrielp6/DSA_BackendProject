package edu.upc.dsa.models;

public class Inventario {
    String username;
    int escudoMaderaComprado;
    int escudoPlataComprado;
    int escudoOroComprado;
    int flechaMaderaComprada;
    int flechaPlataComprada;
    int flechaOroComprada;
    int manzanaComprada;
    int pocionAzulComprada;
    int pocionRojaComprada;

    public Inventario(){

    }
    public Inventario(String username) {
        this.username = username;
        this.escudoMaderaComprado = 0;
        this.escudoPlataComprado = 0;
        this.escudoOroComprado = 0;
        this.flechaMaderaComprada = 0;
        this.flechaPlataComprada = 0;
        this.flechaOroComprada = 0;
        this.manzanaComprada = 0;
        this.pocionAzulComprada = 0;
        this.pocionRojaComprada = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEscudoMaderaComprado() {
        return escudoMaderaComprado;
    }

    public void setEscudoMaderaComprado(int escudoMaderaComprado) {
        this.escudoMaderaComprado = escudoMaderaComprado;
    }

    public int getEscudoPlataComprado() {
        return escudoPlataComprado;
    }

    public void setEscudoPlataComprado(int escudoPlataComprado) {
        this.escudoPlataComprado = escudoPlataComprado;
    }

    public int getEscudoOroComprado() {
        return escudoOroComprado;
    }

    public void setEscudoOroComprado(int escudoOroComprado) {
        this.escudoOroComprado = escudoOroComprado;
    }

    public int getFlechaMaderaComprada() {
        return flechaMaderaComprada;
    }

    public void setFlechaMaderaComprada(int flechaMaderaComprada) {
        this.flechaMaderaComprada = flechaMaderaComprada;
    }

    public int getFlechaPlataComprada() {
        return flechaPlataComprada;
    }

    public void setFlechaPlataComprada(int flechaPlataComprada) {
        this.flechaPlataComprada = flechaPlataComprada;
    }

    public int getFlechaOroComprada() {
        return flechaOroComprada;
    }

    public void setFlechaOroComprada(int flechaOroComprada) {
        this.flechaOroComprada = flechaOroComprada;
    }

    public int getManzanaComprada() {
        return manzanaComprada;
    }

    public void setManzanaComprada(int manzanaComprada) {
        this.manzanaComprada = manzanaComprada;
    }

    public int getPocionAzulComprada() {
        return pocionAzulComprada;
    }

    public void setPocionAzulComprada(int pocionAzulComprada) {
        this.pocionAzulComprada = pocionAzulComprada;
    }

    public int getPocionRojaComprada() {
        return pocionRojaComprada;
    }

    public void setPocionRojaComprada(int pocionRojaComprada) {
        this.pocionRojaComprada = pocionRojaComprada;
    }
}
