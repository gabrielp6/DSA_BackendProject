package edu.upc.dsa.models;

public class CompraRespuesta {

    int monedasActualizadas;

    public CompraRespuesta (){

    }

    public CompraRespuesta(int monedasActualizadas) {
        this.monedasActualizadas = monedasActualizadas;
    }

    public int getMonedasActualizadas() {
        return monedasActualizadas;
    }

    public void setMonedasActualizadas(int monedasActualizadas) {
        this.monedasActualizadas = monedasActualizadas;
    }
}
