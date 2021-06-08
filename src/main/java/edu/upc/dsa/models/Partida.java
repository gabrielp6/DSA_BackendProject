package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Partida {

    String idGame;
    String idUserG; // ID del usuario en partida
    int levelsCompleted = 0; // Para saber en que nivel esta y si pasar al mapa siguiente.
    int score; // Puntuación de la partida.

    public Partida() {
        this.idGame = RandomUtils.getId();
    }

    public Partida(String idUserG, int levelsCompleted, int score) {
        this();
        this.idUserG = idUserG;
        this.levelsCompleted = levelsCompleted;
        this.score = score;
    }

    public String getIdGame() {
        return idGame;
    }

    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    public String getIdUserG() {
        return idUserG;
    }

    public void setIdUserG(String idUserG) {
        this.idUserG = idUserG;
    }

    public int getLevelsCompleted() {
        return levelsCompleted;
    }

    public void setLevelsCompleted(int levelsCompleted) {
        this.levelsCompleted = levelsCompleted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
