package edu.upc.dsa.models;

public class Inventario {
    String username;
    int escudoMadera;
    int escudoPlata;
    int escudoOro;
    int flechaMadera;
    int flechaPlata;
    int flechaOro;
    int manzana;
    int pocionAzul;
    int pocionRoja;

    public Inventario(){

    }
    public Inventario(String username) {
        this.username = username;
        this.escudoMadera = 0;
        this.escudoPlata = 0;
        this.escudoOro = 0;
        this.flechaMadera = 0;
        this.flechaPlata = 0;
        this.flechaOro = 0;
        this.manzana = 0;
        this.pocionAzul = 0;
        this.pocionRoja = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getEscudoMadera() {
        return escudoMadera;
    }

    public void setEscudoMadera(int escudoMadera) {
        this.escudoMadera = escudoMadera;
    }

    public int getEscudoPlata() {
        return escudoPlata;
    }

    public void setEscudoPlata(int escudoPlata) {
        this.escudoPlata = escudoPlata;
    }

    public int getEscudoOro() {
        return escudoOro;
    }

    public void setEscudoOro(int escudoOro) {
        this.escudoOro = escudoOro;
    }

    public int getFlechaMadera() {
        return flechaMadera;
    }

    public void setFlechaMadera(int flechaMadera) {
        this.flechaMadera = flechaMadera;
    }

    public int getFlechaPlata() {
        return flechaPlata;
    }

    public void setFlechaPlata(int flechaPlata) {
        this.flechaPlata = flechaPlata;
    }

    public int getFlechaOro() {
        return flechaOro;
    }

    public void setFlechaOro(int flechaOro) {
        this.flechaOro = flechaOro;
    }

    public int getManzana() {
        return manzana;
    }

    public void setManzana(int manzana) {
        this.manzana = manzana;
    }

    public int getPocionAzul() {
        return pocionAzul;
    }

    public void setPocionAzul(int pocionAzul) {
        this.pocionAzul = pocionAzul;
    }

    public int getPocionRoja() {
        return pocionRoja;
    }

    public void setPocionRoja(int pocionRoja) {
        this.pocionRoja = pocionRoja;
    }
}
