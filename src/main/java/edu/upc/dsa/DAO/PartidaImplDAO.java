package edu.upc.dsa.DAO;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Partida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PartidaImplDAO implements PartidaDAO {

    private static PartidaDAO instance;
    private final Session session;

    private PartidaImplDAO() {

        session = FactorySession.openSession();
    }


    public static PartidaDAO getInstance() {
        if (instance==null) instance = new PartidaImplDAO();
        return instance;
    }


    @Override
    public boolean create(Partida partida) {
        return session.create(partida);
    }

    @Override
    public List<Partida> readAll() {
        Session session = null;
        List<Partida> listaPartida = null;


        try{
            List<String> params= new LinkedList<>();
            String query = "SELECT * FROM Partida;";
            session = FactorySession.openSession();
            //String query = "SELECT * FROM objetos";
            listaPartida = (List) session.queryObjects(query, Partida.class, params);
        }
        catch(Exception e) {
            e.printStackTrace();

        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return listaPartida;
    }

    @Override
    public List<Partida> readAllByParameter(String parameter, Object value) {
        Session session = null;
        List<Partida> listaPartida = null;


        try{
            List<String> params= new LinkedList<>();
            String query = "SELECT * FROM Partida WHERE username= '"+ value +"' ORDER BY puntuacionFinal desc";
            session = FactorySession.openSession();
            //String query = "SELECT * FROM objetos";
            listaPartida = (List) session.queryObjects(query, Partida.class, params);
        }
        catch(Exception e) {
            e.printStackTrace();

        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return listaPartida;
    }

    @Override
    public Partida readByParameter(String parameter, Object value) {
        return ((Partida) session.readByParameter(Partida.class, parameter, value));
    }

    @Override
    public boolean update(Partida partida) {
        return session.update(partida);
    }

    @Override
    public boolean updateByParameter(Partida partida, String parameter, Object value) {
        return session.updateByParameter(partida, parameter, value);
    }

    @Override
    public boolean updateParameterByParameter(String parameter, Object parameterValue, String byParameter, Object byParameterValue) {
        return session.updateParameterByParameter(Partida.class, parameter, parameterValue, byParameter, byParameterValue);
    }

    @Override
    public boolean delete(Partida partida) {
        return session.delete(partida);
    }

    @Override
    public boolean deleteByParameter(String parameter, Object value) {
        return session.deleteByParameter(Partida.class, parameter, value);
    }
}
