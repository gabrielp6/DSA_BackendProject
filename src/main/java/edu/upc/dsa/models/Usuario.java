package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Usuario {

    String ID;
    String username;
    String password;
    String email;
    int vida;
    int fuerza;
    int coins;


    public Usuario() {
    }


    public Usuario(String username, String password, String email) {
        this.ID = RandomUtils.getId();
        this.username = username;
        this.password = password;
        this.email = email;
        this.vida = 100;
        this.fuerza = 3;
        this.coins = 50;
    }



    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", vida=" + vida +
                ", fuerza=" + fuerza +
                ", coins=" + coins +
                '}';
    }
}
