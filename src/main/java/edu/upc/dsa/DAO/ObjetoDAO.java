package edu.upc.dsa.DAO;

import edu.upc.dsa.models.Objeto;

import java.util.List;

public interface ObjetoDAO {

    boolean create(Objeto objeto);

    List<Objeto> readAll();
    Objeto readByParameter(String parameter, Object value);
    List<Objeto> getAllObject();

    boolean exists(String nombre);

    boolean update(Objeto objeto);
    boolean updateByParameter(Objeto objeto, String parameter, Object value);


    boolean delete(Objeto objeto);
    boolean deleteByParameter(String parameter, Object value);



}
