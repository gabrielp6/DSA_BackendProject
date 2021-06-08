package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;

public interface Session<E> {

    boolean create(Object object);
    void save(Object entity);
    void close();


    Object get(Class theClass, String pk);
    Object readByParameter(Class theClass, String byParameter, Object byParameterValue);
    Object readParameterByParameter(Class theClass, String parameter, String byParameter, Object byParameterValue);

    void update(Object object);
    boolean delete(Object object);
    boolean deleteByParameter(Class theClass, String byParameter, Object byParameterValue);


    HashMap<Integer, Object> readAll(Class theClass);
    HashMap<Integer, Object> readAllByParameter(Class theClass, String byParameter, Object byParameterValue);

    List<Object> query(String query, Class theClass, List params);
}
