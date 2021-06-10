package edu.upc.dsa.DAO;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.RecordUsuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordUsuarioImplDAO implements RecordUsuarioDAO {

    private static RecordUsuarioDAO instance;
    private final Session session;

    private RecordUsuarioImplDAO() {

        session = FactorySession.openSession();
    }


    public static RecordUsuarioDAO getInstance() {
        if (instance==null) instance = new RecordUsuarioImplDAO();
        return instance;


    }
    @Override
    public boolean create(RecordUsuario record) {
        return session.create(record);
    }

    @Override
    public List<RecordUsuario> readAll() {
        Session session;
        List<RecordUsuario> listaRecords = new ArrayList<>();

        HashMap<Integer, Object> result;

        session = FactorySession.openSession();
        result = session.readAll(Partida.class);


        for (Object object : result.values()) {
            listaRecords.add((RecordUsuario) object);
        }

        session.close();
        return listaRecords;
    }

    @Override
    public RecordUsuario readByParameter(String parameter, Object value) {
        return ((RecordUsuario) session.readByParameter(RecordUsuario.class, parameter, value));
    }

    @Override
    public boolean update(RecordUsuario record) {
        return session.update(record);
    }

    @Override
    public boolean updateByParameter(RecordUsuario record, String parameter, Object value) {
        return session.updateByParameter(record, parameter, value);
    }

    @Override
    public boolean updateParameterByParameter(String parameter, Object parameterValue, String byParameter, Object byParameterValue) {
        return session.updateParameterByParameter(RecordUsuario.class, parameter, parameterValue, byParameter, byParameterValue);
    }

    @Override
    public boolean delete(RecordUsuario record) {
        return session.delete(record);
    }

    @Override
    public boolean deleteByParameter(String parameter, Object value) {
        return session.deleteByParameter(RecordUsuario.class, parameter, value);
    }
}
