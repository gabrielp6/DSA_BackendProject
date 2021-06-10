package edu.upc.dsa.models;

public class Objeto {

    String nombre;
    int coste;
    String descripcion;
    String avatar;



    public Objeto() {
    }

    public Objeto(String nombre, int coste, String descripcion, String avatar) {
        this.nombre = nombre;
        this.coste = coste;
        this.descripcion = descripcion;
        this.avatar = avatar;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
