package edu.upc.dsa.models;

public class Mapa {

    String idMap;
    String nameMap;
    public Mapa() {
    }

    public Mapa(String nombre) {
        this.nameMap = nombre;
    }

    public String getIdMap() {
        return idMap;
    }

    public void setIdMap(String idMap) {
        this.idMap = idMap;
    }

    public String getNombre() {
        return nameMap;
    }

    public void setNombre(String nombre) {
        this.nameMap = nombre;
    }

}
