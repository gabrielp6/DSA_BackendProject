package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {

    //FUNCIONES QUE USAREMOS EN CADA DAO POR SEPARADO CON SUS CLASES
    boolean create(Object object);
    void save(Object entity);
    void close();


    Object get(Class theClass, String pk);
    Object readByParameter(Class theClass, String byParameter, Object byParameterValue);
    Object readParameterByParameter(Class theClass, String parameter, String byParameter, Object byParameterValue);

    boolean update(Object object);
    boolean updateByParameter(Object object, String byParameter, Object byParameterValue);
    boolean updateParameterByParameter(Class theClass, String parameter, Object parameterValue, String byParameter, Object byParameterValue);

    boolean delete(Object object);
    boolean deleteByParameter(Class theClass, String byParameter, Object byParameterValue);

    List<Object> queryObjects(String query, Class theClass, List params);

    HashMap<Integer, Object> readAll(Class theClass);
    HashMap<Integer, Object> readAllByParameter(Class theClass, String byParameter, Object byParameterValue);
}
