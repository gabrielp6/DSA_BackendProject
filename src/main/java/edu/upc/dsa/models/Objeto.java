package edu.upc.dsa.models;

public class Objeto {

    String idObject;
    String name;
    int cost;
    String idUser;
    int healthPointsAdded;
    int defensePointsAdded;



    public Objeto() {
    }

    public Objeto(String name, int cost) {
        this.name = name;
        this.cost = cost;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getIdObject() {
        return idObject;
    }

    public void setIdObject(String idObject) {
        this.idObject = idObject;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getHealthPointsAdded() {
        return healthPointsAdded;
    }

    public void setHealthPointsAdded(int healthPointsAdded) {
        this.healthPointsAdded = healthPointsAdded;
    }

    public int getDefensePointsAdded() {
        return defensePointsAdded;
    }

    public void setDefensePointsAdded(int defensePointsAdded) {
        this.defensePointsAdded = defensePointsAdded;
    }
}
