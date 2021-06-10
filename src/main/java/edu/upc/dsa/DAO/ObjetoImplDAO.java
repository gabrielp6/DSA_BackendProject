package edu.upc.dsa.DAO;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.Objeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjetoImplDAO implements ObjetoDAO{

    private static ObjetoDAO instance;
    private final Session session;


    private ObjetoImplDAO() {
        session = FactorySession.openSession();
    }

    public static ObjetoDAO getInstance() {
        if (instance==null) instance = new ObjetoImplDAO();
        return instance;
    }


    @Override
    public boolean create(Objeto objeto) {
        return session.create(objeto);
    }

    @Override
    public List<Objeto> readAll() {
        Session session;
        List<Objeto> listaObjetos;

        HashMap<Integer, Objeto> result;

        session = FactorySession.openSession();
        result = session.readAll(Objeto.class);

        listaObjetos = new ArrayList<>();

        for (Objeto objeto : result.values()) {
            listaObjetos.add((Objeto) objeto);
        }

        session.close();

        return listaObjetos;
    }

    @Override
    public Objeto readByParameter(String parameter, Object value){
        return ((Objeto) session.readByParameter(Objeto.class, parameter, value));
    }

    @Override
    public boolean existsByParameter(String nombre) {
        return (session.readByParameter(Objeto.class, "nombre", nombre) != null);
    }

    @Override
    public boolean update(Objeto objeto) {
        return session.update(objeto);
    }

    @Override
    public boolean updateByParameter(Objeto objeto, String parameter, Object value) {
        return session.updateByParameter(Objeto.class, parameter, value);
    }

    @Override
    public boolean delete(Objeto objeto) {
        return session.delete(objeto);
    }

    @Override
    public boolean deleteByParameter(String parameter, Object value) {
        return session.deleteByParameter(Objeto.class, parameter, value);
    }
}
