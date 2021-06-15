package edu.upc.dsa.DAO;

import edu.upc.dsa.FactorySession;
import edu.upc.dsa.Session;
import edu.upc.dsa.models.Inventario;
import edu.upc.dsa.models.Usuario;
import io.swagger.models.auth.In;

public class InventarioImplDAO implements InventarioDAO{

    private static InventarioDAO instance;
    private final Session session;


    private InventarioImplDAO() {
        session = FactorySession.openSession();
    }

    public static InventarioDAO getInstance() {
        if (instance==null) instance = new InventarioImplDAO();
        return instance;
    }

    @Override
    public boolean create(Inventario inventario) {
        return session.create(inventario);
    }

    @Override
    public Inventario readByParameter(String parameter, Object value) {
        return ((Inventario) session.readByParameter(Inventario.class, parameter, value));
    }

    @Override
    public Object readParameterByParameter(String parameter, String byParameter, Object value) {
        return session.readParameterByParameter(Usuario.class, parameter, byParameter, value);
    }

    @Override
    public boolean update(Inventario inventario) {
        return session.update(inventario);
    }

    @Override
    public boolean updateByParameter(Inventario inventario, String parameter, Object value) {
        return session.updateByParameter(Inventario.class, parameter, value);
    }

    @Override
    public boolean updateParameterByParameter(String parameter, Object parameterValue, String byParameter, Object byParameterValue) {
        return session.updateParameterByParameter(Inventario.class, parameter, parameterValue, byParameter, byParameterValue);
    }

    @Override
    public boolean delete(Inventario inventario) {
        return session.delete(inventario);
    }

    @Override
    public boolean deleteByParameter(String parameter, Object value) {
        return session.deleteByParameter(Inventario.class, parameter, value);
    }
}
