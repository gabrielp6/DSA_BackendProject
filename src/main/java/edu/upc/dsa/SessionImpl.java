package edu.upc.dsa;

import edu.upc.dsa.util.ObjectHelper;
import edu.upc.dsa.util.QueryHelper;
import java.util.logging.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;
    static final Logger logger = Logger.getLogger(SessionImpl.class.getName());


    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);
        System.out.println("Insert Query" + insertQuery);
        //INSERT INTO USUARIO (username, password, email, coins) VALUES (?,?,?,?)
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            int i = 1;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean create(Object object) {

        try {

            String insertQuery = QueryHelper.createQueryINSERT(object);
            PreparedStatement pstm = null;

            pstm = conn.prepareStatement(insertQuery);

            int i = 1;
            for (String field : ObjectHelper.getFields(object)) {
                System.out.println(i+" "+field);
                pstm.setObject(i++, ObjectHelper.getter(object, field));

            }

            System.out.println(insertQuery);
            pstm.executeQuery();

            return true;

        } catch (SQLException exception) {

            exception.printStackTrace();
            return false;

        }

    }

    public void close() {

    }

    public Object get(Class theClass, String pk) {
        //"SELECT * FROM USUARIO WHERE " + pk + "=?"
        return null;
    }

    public boolean update(Object object) {
        try {

            String updateQuery = QueryHelper.createQueryUPDATE(object);

            PreparedStatement pstm = null;

            pstm = conn.prepareStatement(updateQuery);
            String field;
            int i = 1;
            while (i < ObjectHelper.getFields(object).length) {
                field = ObjectHelper.getFields(object)[i];
                pstm.setObject(i++, ObjectHelper.getter(object, field));
            }
            pstm.setObject(i++, ObjectHelper.getter(object, ObjectHelper.getFields(object)[0]));
            pstm.executeQuery();

            return true;


        } catch (SQLException exception) {

            exception.printStackTrace();
            return false;

        }
    }

    public boolean updateByParameter(Object object, String byParameter, Object byParameterValue) {

        try {

            String updateQuery = QueryHelper.createQueryUPDATEbyParameter(object.getClass(), byParameter);

            PreparedStatement pstm = null;
            pstm = conn.prepareStatement(updateQuery);
            String field;
            int i = 1;

            while (i < ObjectHelper.getFields(object).length) {
                field = ObjectHelper.getFields(object)[i];
                pstm.setObject(i++, ObjectHelper.getter(object, field));
            }

            pstm.setObject(i++, ObjectHelper.getter(object, byParameterValue.toString()));
            pstm.executeQuery();

            return true;

        } catch (SQLException exception) {

            exception.printStackTrace();
            return false;

        }

    }


    public boolean updateParameterByParameter(Class theClass, String parameter, Object parameterValue, String byParameter, Object byParameterValue) {

        try {

            String updateQuery = QueryHelper.createQueryUPDATEparameterByParameter(theClass, parameter, byParameter);

            PreparedStatement pstm;

            pstm = conn.prepareStatement(updateQuery);
            pstm.setObject(1, parameterValue);
            pstm.setObject(2, byParameterValue);
            pstm.executeQuery();

            return true;

        } catch (SQLException exception) {

            exception.printStackTrace();
            return false;

        }

    }

    public boolean delete(Object object)  {

        try {

            String deleteQuery = QueryHelper.createQueryDELETE(object);
            PreparedStatement pstm = null;
            int id = ObjectHelper.getId(object);
            pstm = conn.prepareStatement(deleteQuery);
            pstm.setInt(1, id);
            pstm.executeQuery();

            return true;

        } catch (SQLException | IllegalAccessException exception) {

            exception.printStackTrace();

            return false;

        }

    }

    public boolean deleteByParameter(Class theClass, String byParameter, Object byParameterValue)  {

        try {

            String deleteQuery = QueryHelper.createQueryDELETEbyParameter(theClass, byParameter);
            PreparedStatement pstm = null;
            pstm = conn.prepareStatement(deleteQuery);
            pstm.setObject(1, byParameterValue);
            pstm.executeQuery();

            return true;

        } catch (SQLException exception) {

            exception.printStackTrace();
            return false;

        }
    }

    public Object readParameterByParameter(Class theClass, String parameter, String byParameter, Object byParameterValue) {

        try {
            String selectQuery = QueryHelper.createQuerySELECTparameterByParameter(theClass, parameter, byParameter);
            PreparedStatement pstm;
            ResultSet resultSet;
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, byParameterValue);
            resultSet = pstm.executeQuery();
            if (resultSet.next()) return resultSet.getObject(1);
            else return null;

        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }

    }


    public Object readByParameter(Class theClass, String byParameter, Object byParameterValue) {

        String selectQuery = QueryHelper.createQuerySELECTbyParameter(theClass, byParameter);

        try {

            PreparedStatement pstm = null;
            Object object = theClass.getDeclaredConstructor().newInstance();

            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, byParameterValue);
            pstm.executeQuery();
            ResultSet resultSet = pstm.getResultSet();

            if (resultSet.next()) {

                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String field = rsmd.getColumnName(i);
                    ObjectHelper.setter(object, field, resultSet.getObject(i));
                }

                return object;

            } else {

                return null;

            }

        } catch (SQLException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException exception) {

            exception.printStackTrace();
            return null;

        }
    }

    public HashMap<Integer, Object> readAll(Class theClass) {           //obtener todos (aplicable a todas las funciones)

        try {
            HashMap<Integer, Object> result = new HashMap<>();
            String selectQuery = QueryHelper.createQuerySELECTall(theClass);
            PreparedStatement pstm;
            ResultSet resultSet;
            Object object;
            int id;
            object = theClass.getDeclaredConstructor().newInstance();
            pstm = conn.prepareStatement(selectQuery);
            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String field = rsmd.getColumnName(i);
                    ObjectHelper.setter(object, field, resultSet.getObject(i));
                }
                result.put((int) resultSet.getObject(1), object);
                object = theClass.getDeclaredConstructor().newInstance();
            }

            return result;

        } catch (SQLException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException exception) {

            exception.printStackTrace();
            return null;

        }


    }


    public HashMap<Integer, Object> readAllByParameter(Class theClass, String byParameter, Object byParameterValue) {
        //obtener todos los que cumplan una cierta condición (aplicable a todas las clases)

        try {

            HashMap<Integer, Object> result = new HashMap<>();
            String selectQuery = QueryHelper.createQuerySELECTbyParameter(theClass, byParameter);
            PreparedStatement pstm;
            ResultSet resultSet;
            Object object;

            int id;
            object = theClass.getDeclaredConstructor().newInstance();
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, byParameterValue);

            resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String field = rsmd.getColumnName(i);
                    ObjectHelper.setter(object, field, resultSet.getObject(i));
                }
                result.put((int) resultSet.getObject(1), object);
                object = theClass.getDeclaredConstructor().newInstance();
            }

            return result;

        } catch (SQLException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException exception) {

            exception.printStackTrace();
            return null;

        }
    }

    @Override
    public List<Object> queryObjects(String query, Class theClass, List params) {
        PreparedStatement pstm = null;
        List<Object> objResultado = new LinkedList<>();
        Object obj = null;
        try{
            obj = theClass.newInstance();
            pstm = conn.prepareStatement(query);
            int i = 1;
            for(Object o: params){
                pstm.setObject(i, params.get(i-1));
                i++;
            }

            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                for(int j=1;j<=resultSetMetaData.getColumnCount();j++){
                    String name = resultSetMetaData.getColumnName(j);
                    ObjectHelper.setter(obj,name, resultSet.getObject(j));

                }
                logger.info("objeto añadido " +obj);
                objResultado.add(obj);
                obj = theClass.newInstance();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return objResultado;
    }
}
