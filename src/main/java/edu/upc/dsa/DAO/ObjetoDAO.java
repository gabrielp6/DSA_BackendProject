package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Objeto;

import java.util.List;

public interface ObjetoDAO {

    boolean crearObjeto(Objeto objeto);

    List<Objeto> listaObjetos();

    static boolean exists(String nombre);

    boolean eliminarObjeto(Objeto objeto);



}
