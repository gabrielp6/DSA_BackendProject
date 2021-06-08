package edu.upc.dsa.models;

import java.util.List;

public class Usuario {

    String id;
    String username;
    String password;
    String email;
    int health;
    int defense;
    int coins;

    List<Objeto> objectsList;
    List<Partida> gamesList;


    public Usuario() {
    }


    public Usuario(String username, String password, String email, int coins) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.coins = coins;
    }

    public Usuario(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Objeto> getObjectsList() {
        return objectsList;
    }

    public void setObjectsList(List<Objeto> objectsList) {
        this.objectsList = objectsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public List<Partida> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<Partida> gamesList) {
        this.gamesList = gamesList;
    }
}
