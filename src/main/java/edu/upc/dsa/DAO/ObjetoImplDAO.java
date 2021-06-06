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



    public boolean crearObjeto(Objeto objeto) {
        return session.create(objeto);
    }

    // READ
    public List<Objeto> listaObjetos(){

        Session session;
        List<Objeto> listaObjetos;

        HashMap<Integer, Object> result;

        session = FactorySession.openSession();
        result = session.readAll(Objeto.class);

        listaObjetos = new ArrayList<>();

        for (Object object : result.values()) {
            listaObjetos.add((Objeto) object);
        }

        session.close();

        return listaObjetos;
    }


    public boolean exists(String name) {

        return (session.readByParameter(Objeto.class, "name", name) != null);
    }



    public boolean eliminarObjeto(Objeto objeto) {

        return session.delete(objeto);

    }
}
