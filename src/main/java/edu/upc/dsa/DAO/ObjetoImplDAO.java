package edu.upc.dsa.DAO;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.Objeto;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;


public class ObjetoImplDAO implements ObjetoDAO{

    private static ObjetoDAO instance;
    private final Session session;
    static final Logger logger = Logger.getLogger(ObjetoImplDAO.class.getName());

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
        Session session = null;
        List<Objeto> objetosList = null;


        try{
            List<String> params= new LinkedList<>();
            String query = "SELECT * FROM Objeto;";
            session = FactorySession.openSession();
            //String query = "SELECT * FROM objetos";
            objetosList = (List) session.queryObjects(query, Objeto.class, params);
            logger.info("objetoslist: " + objetosList);
        }
        catch(Exception e) {
            e.printStackTrace();

        }
        finally {
            if(session!=null){
                session.close();
            }
        }
        return objetosList;
    }

    @Override
    public Objeto readByParameter(String parameter, Object value){
        return ((Objeto) session.readByParameter(Objeto.class, parameter, value));
    }

    @Override
    public boolean exists(String nombre) {
        if (session.readByParameter(Objeto.class, "nombre", nombre) == null)
            return false;
        else
            return true;
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
